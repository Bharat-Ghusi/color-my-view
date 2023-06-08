package com.example.colormyviews

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.databinding.DataBindingUtil
import com.example.colormyviews.databinding.ActivityMainBinding
import com.example.colormyviews.ui.theme.ColorMyViewsTheme

class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //set clickable color
        setListner()

    }

    private fun setListner() {
        val viewList: List<View> = listOf(
            binding.boxOne, binding.boxTwo,
            binding.boxThree, binding.boxFour, binding.boxFive,binding.constraintLayout,binding.btnOne,binding.btnTwo,binding.btnThree
        )
        for (item in viewList) {
            item.setOnClickListener { setColor(it) }
        }
    }

    private fun setColor(view: View) {
        when (view.id) {
            R.id.box_one -> view.setBackgroundColor(Color.MAGENTA)
            R.id.box_two -> view.setBackgroundColor(Color.CYAN)
            //Android resources
            R.id.box_three -> view.setBackgroundResource(android.R.color.holo_purple)
            R.id.box_four -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five -> view.setBackgroundResource(android.R.color.holo_red_dark)


            R.id.btn_one -> binding.boxTwo.setBackgroundColor(Color.YELLOW)
            R.id.btn_two -> binding.boxTwo.setBackgroundColor(Color.BLUE)
            R.id.btn_three -> binding.boxThree.setBackgroundResource(android.R.color.holo_blue_light)

            else -> view.setBackgroundColor(Color.DKGRAY)
        }
    }

}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ColorMyViewsTheme {
        Greeting("Android")
    }
}