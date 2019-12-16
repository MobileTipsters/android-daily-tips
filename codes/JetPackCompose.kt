/*
  Your Activity, in the onCreate method,
  setContent{
  	//call the composable method
	setTextIntoTheColumn("TextView Text1", "TextView Text2")
  } 
*/

@Composable
fun setTextIntoTheColumn(messageOne: String, messageTwo: String) {
   Column {
        Text(text = messageOne)
        Text(text = messageTwo)
    }
}