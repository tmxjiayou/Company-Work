var num1 = 0;//存储第一个数字
var oper="";//运算符变量
var flag = false;//运算符是否被点击过
var point = false;//小数点是否被点击过
var result = false;
//添加数字
function addNum(n){
	var num = document.getElementById("t").value;
	//判断输入的数字是否为空（为空则直接将传进来的参数赋值给文本框） 或 符号是否被点击过
	if(num == "0"||flag||result){
		document.getElementById("t").value = n;
	//符号被点击过则返回false，以进行连续运算
		flag = false;
		result = false;
	//若为假 控制输入的数字的长度
	}else if(num.length<11){
		//将原有的参数和所传值相加
		document.getElementById("t").value += n;
		}else{
		alert("输入的数值过大");	
		}
}
//添加运算符
function flagOp(op){
//判断运算符是否为空
	if(oper==""){
		//将文本框的值赋给第一个数
		num1 = document.getElementById("t").value;	
	//运算符不为空，计算结果
	}else{
		resNum();
	}
	//将符号参数赋值给oper
	oper=op;
	//符号被点击过
	flag=true;
	point = false;
}
//添加小数点
function getPoint(){
	if(result){
		onClickCe();
	}
	if(!point){
		document.getElementById("t").value = document.getElementById("t").value + ".";
		point = true;
		}
}
function getKaiFang(){	
	document.getElementById("t").value = Math.sqrt(document.getElementById("t").value*1);
}
function getPingFang(){
	document.getElementById("t").value = Math.pow(document.getElementById("t").value*1,2);
}
//计算结果
function resNum(){
	if(oper!=""){
	switch(oper){
		case '+': num1 = num1*1 + document.getElementById("t").value*1;
			break;
		case '-': num1 = num1*1 - document.getElementById("t").value*1;
			break;
		case '*': num1 = (num1*1) * (document.getElementById("t").value*1);
			break;
		case '/': 
		if(document.getElementById("t").value != "0"){
			num1 = (num1*1) / (document.getElementById("t").value*1);
		}else{
			alert("除数不能为0");
		}
			break;
		}
		
		//将符号清空 输出结果  符号改为未点击状态
		oper="";
		document.getElementById("t").value = num1;
		flag=false;
		point = false;
		result = true;

		//precent = false;
    }
}
//清除
function onClickCe(){
	document.getElementById("t").value="0";  
	oper="";
	flag=false;
	point = false;
	result = false;
	num1=0;
	//precent = false;
	}
//删除
function delC(){
	var num = document.getElementById("t").value;
	if(num.length > 1){
		//截取字符串（第一位，字符串长度减一位） 
		document.getElementById("t").value = num.substr(0,num.length-1);
	}else{
		document.getElementById("t").value = "0";
	}
}