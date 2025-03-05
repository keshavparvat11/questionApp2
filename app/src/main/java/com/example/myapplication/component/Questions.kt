package com.example.myapplication.component

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.questions.QuestionItem
import com.example.myapplication.sceen.QuestionVivemodel
import com.example.myapplication.util.AppColors

@Composable
fun Questions(viewMode: QuestionVivemodel){
    val question = viewMode.data.value.data?.toMutableList()
    val questionIndex = remember {
        mutableStateOf(0)
    }
    if (viewMode.data.value.loading == true) {
        CircularProgressIndicator()
        Log.d("Loadingg", "Questions: Lodinnnnnnng")
    } else{
        if (question != null)
        {
            val question = question[questionIndex.value]
            DisplayQuestions(question = question,questionIndex = questionIndex,viewMode){
                questionIndex.value = questionIndex.value + 1
            }
        }
    }

}
//@Preview
@SuppressLint("RememberReturnType")
@Composable
fun DisplayQuestions(question: QuestionItem,
                     questionIndex: MutableState<Int>,
                     viewModel: QuestionVivemodel,
                     onNextClicked: (Int) -> Unit ={},
                     ){
    val choicesState = remember(question) {
        question.choices.toMutableList()
    }
    val answerState = remember(question) {
        mutableStateOf<Int?>(null)
    }
    val correctAnswerState = remember(question) {
        mutableStateOf<Boolean?>(null)

    }
    val updateAnswer: (Int) -> Unit = remember(question) {
        {
            answerState.value = it
            correctAnswerState.value = choicesState[it] == question.answer
        }

    }
    Surface(modifier = Modifier.fillMaxWidth()
        .fillMaxHeight()
        .padding(10.dp), color = AppColors.mDarkPurple) {
        Column(modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start) {
            quetionTracker(curr = questionIndex.value, outOf = 100)
            DoatedLine(PathEffect.dashPathEffect(floatArrayOf(10f,10f),0f))
            Column {
                Text(text =question.question,
                    modifier = Modifier.padding(6.dp)
                    .fillMaxHeight(0.3f)
                    .align(alignment = Alignment.Start),
                    color = AppColors.mLightGray,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 22.sp)
                //choices
                choicesState.forEachIndexed { index, s ->
                    Row(modifier = Modifier.padding(3.dp)
                        .fillMaxWidth()
                        .height(45.dp)
                        .border(width = 4.dp,
                            brush = Brush.linearGradient(listOf(AppColors.mOffDarkPurple,
                                AppColors.mOffDarkPurple)), shape = RoundedCornerShape(15.dp)
                        ).clip(RoundedCornerShape(50.dp))
                        .background(color = Color.Transparent) ,
                        verticalAlignment = Alignment.CenterVertically){
                            RadioButton(
                                selected = (answerState.value == index),
                                onClick = { updateAnswer(index) },
                                modifier = Modifier.padding(start = 16.dp),
                                colors = RadioButtonDefaults.colors(selectedColor =
                                if(correctAnswerState.value == true && answerState.value == index)
                                { Color.Green.copy(alpha = 0.2f) }
                                else{ Color.Red.copy(alpha = 0.2f) }
                                ))
                        val annotatedString = buildAnnotatedString {
                            withStyle(style = SpanStyle(color = if(correctAnswerState.value == true && index == answerState.value){
                                Color.Green
                            }else if(correctAnswerState.value == false && answerState.value == index){
                                Color.Red
                            }else{
                                AppColors.mOffWhite
                            }, fontSize = 17.sp)){
                                append(s)
                            }
                        }
                        Text(text = annotatedString)

                        }


                            }
                Spacer(modifier = Modifier.height(50.dp))
                Button(onClick = { onNextClicked(questionIndex.value) },modifier = Modifier
                    .padding(3.dp)
                    .align(alignment = Alignment.CenterHorizontally),
                    shape = RoundedCornerShape(34.dp),
                    colors = ButtonDefaults.buttonColors(AppColors.mLightBlue)
                ) {
                    Text(text = "Next",modifier = Modifier.padding(4.dp))
                }

                    }
                }
            }
        }


