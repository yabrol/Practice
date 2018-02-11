function moveIt(){
  	var coords = new Array(10,50,100,130,175,225,260,300,320,350);
  	var x = coords[Math.floor((Math.random()*10))];
  	var y = coords[Math.floor((Math.random()*10))];
  	var colors = new Array("#0066AA", "#0000FF", "#FF0000", "#00FF00");
	var color = colors[Math.floor((Math.random()*4))];
	$("#elusiveText").css({"top": y + "px", "left": x + "px", "background-color": color});
  // $("#elusiveText").css({"top": y + "px", "left": x + "px"})
  $("#elusiveText2").css({"top": x + "px", "left": y + "px"});
}

