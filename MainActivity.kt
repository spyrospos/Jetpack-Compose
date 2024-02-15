package com.example.firstjetpackcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.firstjetpackcomposeapp.ui.theme.FirstJetpackComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstJetpackComposeAppTheme {
                var name by remember { //αρχικοποιηση μεταβλητης name, remember(εκτελειται μια φορα η αρχικοποιηση)
                    mutableStateOf("")
                }
                var names by remember {
                    mutableStateOf(listOf<String>())
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Row (
                        modifier = Modifier.fillMaxWidth()
                    ){
                        OutlinedTextField(
                            value = name, // αρχικοποιηση κειμενου
                            onValueChange = { text ->
                                name = text // αλλαζει το κειμενο -> εκτελεση εντολων
                            },
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.width(15.dp))
                        Button(onClick = {
                            if (name.isNotBlank()){
                                names = names + name
                                name = ""
                                println("Added name: $name")
                                println("Updated names list: $names")
                            }
                        }) {
                            Text(text = "Add")
                        }
                    }

                    LazyColumn{
                        items(names){currentName->
                            Text(
                                 text = currentName,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(15.dp)
                            )
                            Divider()
                        }
                    }
                }
            }
        }
    }
}



