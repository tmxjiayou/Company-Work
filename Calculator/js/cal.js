var num1 = 0;//�洢��һ������
var oper="";//���������
var flag = false;//������Ƿ񱻵����
var point = false;//С�����Ƿ񱻵����
var result = false;
//�������
function addNum(n){
	var num = document.getElementById("t").value;
	//�ж�����������Ƿ�Ϊ�գ�Ϊ����ֱ�ӽ��������Ĳ�����ֵ���ı��� �� �����Ƿ񱻵����
	if(num == "0"||flag||result){
		document.getElementById("t").value = n;
	//���ű�������򷵻�false���Խ�����������
		flag = false;
		result = false;
	//��Ϊ�� ������������ֵĳ���
	}else if(num.length<11){
		//��ԭ�еĲ���������ֵ���
		document.getElementById("t").value += n;
		}else{
		alert("�������ֵ����");	
		}
}
//��������
function flagOp(op){
//�ж�������Ƿ�Ϊ��
	if(oper==""){
		//���ı����ֵ������һ����
		num1 = document.getElementById("t").value;	
	//�������Ϊ�գ�������
	}else{
		resNum();
	}
	//�����Ų�����ֵ��oper
	oper=op;
	//���ű������
	flag=true;
	point = false;
}
//���С����
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
//������
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
			alert("��������Ϊ0");
		}
			break;
		}
		
		//��������� ������  ���Ÿ�Ϊδ���״̬
		oper="";
		document.getElementById("t").value = num1;
		flag=false;
		point = false;
		result = true;

		//precent = false;
    }
}
//���
function onClickCe(){
	document.getElementById("t").value="0";  
	oper="";
	flag=false;
	point = false;
	result = false;
	num1=0;
	//precent = false;
	}
//ɾ��
function delC(){
	var num = document.getElementById("t").value;
	if(num.length > 1){
		//��ȡ�ַ�������һλ���ַ������ȼ�һλ�� 
		document.getElementById("t").value = num.substr(0,num.length-1);
	}else{
		document.getElementById("t").value = "0";
	}
}