for(var i = 0;i<21;i++){
	document.getElementById("b"+i).style.width = "60px";
	document.getElementById("b"+i).style.height = "50px";
	document.getElementById("b"+i).className="mr";
	document.getElementById("b"+i).onmouseover=function (){this.className="ys"};
	document.getElementById("b"+i).onmouseout=function (){this.className="mr"};
	document.getElementById("b"+i).onmousedown=function (){this.className="dj"};
	document.getElementById("b"+i).onmouseup=function (){this.className="fk"};
	} 
	document.getElementById("b20").style.width = "260px";
	document.getElementById("b20").style.height = "50px";