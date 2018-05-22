###Bootstrap总结
###起步：
      工具：Bootlint

      禁止响应布局:
      1.移除设置浏览器视口的（viewport的标签）：<meta>
      2.通过为.container类设置一个width值从而覆盖框架默认的width设置
      3.若使用了导航条，需要移除所有的导航条的折叠和展开行为

###全局CSS样式：
      html5文档类型
      <!DOCTYPE html>
      <html lang="zh-CN">
       ...
 	  </html>

   移动设备优先（<head>之中添加viewport元数据标签）

     <meta name="viewport" content="width=device-width, initial=1">
   
   禁止缩放：user-scalable=no    

   布局容器：
   Bootstrap需要为页面内容和栅格系统包裹一个.container容器。由于padding等属性的原因，这两类容器不能相互嵌套

     .container类用于固定宽度并支持响应式布局的容器。
     <div class="container">
     ...
     </div>

     .container-fluid类似于100%宽度，占据全部视口（viewport）的容器
     <div class="container-fluid">
     ...
     </div>

栅格系统：
   
    随着屏幕或视口（viewport）尺寸的增加，系统会自动分为最多12列
    栅格系统用于一系列的行（row）和（column）的组合来创建页面，你的内容就可以放入这些创建好的布局中。
   
      行（row）必须包含在.container（固定宽度）或.container-fluid(100%宽度)中，以便为其赋予更合适的排列（aligment）和内补（padding）
      通过行（row）在水平方向创建一组“列（column）”
      内容直接放于colummn中，并且只有其才为row的直接子元素
      类似.row和.col-xs-4这种预定义的类，也以用来快速的创建栅格布局
      通过为列column设置padding属性，从而创建列与列之间的间隔（gutter）.通过为.row元素设置负值margin从而抵消掉为.container元素设置的padding,也就间接为行row所包含的列column抵消掉了padding

   媒体查询：在栅格系统中，我们在less文件中使用媒体查询（media query）来创建关键的分界点阈值：
      
      手机：@media (max-width: @screen-xs-max) { ... }
      平板：@media (min-width: @screen-sm-min){...}
      桌面显示器：@media (min-width: @screen-md-min){...}
      大桌面显示器：@media (min-width: @screen-lg-min){...}

   实例：从堆叠到水平排列
     
    使用单一一组的.col-md-*栅格类，可以创建基本的栅格系统，在手机平板上是堆叠在一起，在中等屏幕上变为水平排列。所有的列（column）必须放在row里面

	 <div class="row">
	 	<div class="col-md-1"></div>
        <div class="col-md-1"></div>
     </div>
     <div class="row">
	 	<div class="col-md-4"></div>
        <div class="col-md-8"></div>
     </div>

   实例：流式布局容器：

   		 
     <div class="container-fluid">
	    <div class="row">
			...
        </div>
     </div>

   实例：移动设备和桌面屏幕

	 针对超小屏幕和中等屏幕设备所定义的类 .col-xs-*和.col-md-*

     <div class="row">
     	<div class="col-xs-12 col-md-8">.col-xs-12 .col-md-8</div>
     	<div class="col-xs-6 col-md-4">.col-xs-6 .col-md-4</div>
     </div>
     
     <div class="row">
     	<div class="col-xs-6 col-md-4">.col-xs-6 .col-md-4</div>
     	<div class="col-xs-6 col-md-4">.col-xs-6 .col-md-4</div>
    	<div class="col-xs-6 col-md-4">.col-xs-6 .col-md-4</div>
     </div>

   实例：手机、平板、桌面：

	 <div class="row">
		<div class="col-xs-12 col-sm-6 col-md-8">.col-xs-12 .col-sm-6 .col-md-8</div>
        <div class="col-xs-6 col-md-4">.col-xs-6 .col-md-4</div>
     <div>

   实例：多余的列（column）将另起一行排列（如果在一个.row内包含的列大于12个，包含多余列的元素将作为一个整体单元从另起一行排列）

	 <div class="row">
		<div class="col-xs-9">.col-xs-9</div>
        <div class="col-xs-4">.col-xs-4(超出的行将去新的一行进行展示)</div>
     </div>

   当列的高度超过其他的高度时，可以使用clear visible-xs-block

    <div class="col-sm-5 col-sm-offset-2 col-md-6 col-md-offset-0">col-sm-5 col-sm-offset-2 col-md-6 col-md-offset-0
    </div>

   列偏移（使用.col-md-offset-*类可以将列向右侧偏移。这些类实际是通过使用*选择器为当前元素增加了左侧的边距（margin）例如：.col-md-offset-4将元素.col-md-4元素向右侧偏移了4个列的宽度）

   嵌套列
    
    <div class="row">
        <div class="col-sm-9">
        Level 1: .col-sm-9
            <div class="row">
                <div class="col-xs-8 col-sm-6">
                Level 2: .col-xs-8 .col-sm-6
         </div>
         <div class="col-xs-4 col-sm-6">
             Level 2: .col-xs-4 .col-sm-6
         </div>
         </div>
         </div>
     </div>

    
   列排序：.col-md-push-*和.col-md-pull-*类就可以很容易的改变列（column）的顺序

     
     <div class="row">
		<div class="col-md-9 col-md-push-3">.col-md-9 .col-md-pull-9</div>
     </div>
    
   Less mixin和变量
   除了用于快速的布局的预定义的栅格类，Bootstrap还包含了一组Less变量和mixin用于生成简单的，语义化的布局
  
     变量：通过变量来定义列数、槽宽、媒体查询阈值（用于确定合适让列浮动）
     @grid-columns: 12;
     @grid-gutter-width: 30px;
     @grid-float-breakpoint: 768px;

   mixin用来和栅格变量一同使用，为每个column生成语义化的CSS代码

   你可以重新修改这些变量的值，或者用默认值调用这些mixin。

     .wrapper {
   		.make-row();
	 }
	 .content-main {
     .make-lg-column(8);
	 }
	 .content-secondary {
  		.make-lg-column(3);
    	.make-lg-column-offset(1);
	 }

     <div class="wrapper">
  		<div class="content-main">...</div>
  		<div class="content-secondary">...</div>
	 </div>

#####排版
   
   标题（<h1><h6>都可以使用）还提供了.h1到.h6类，为的是给内联inline属性的文本赋予标题的样式
   
   页面主体：将全局font-size设置为14px,line-height设置为1.428.这些属性直接赋予<body>元素和所有段落元素。另外（段落）元素还被设置为等于行高的1/2

   中心内容：通过添加.lead类可以让段落突出显示

     <p class="lead">...</p>

     内联文本元素
      Marked text

      <mark>highlight</mark>

      被删除文本
      对于被删除的文本使用 <del>标签
   
      无用文本，没用的文本使用标签<s>

      插入文本<ins></ins>

      带下划线的文本<u></u>

      小号文本<small></small> 行内元素.small类代替任何<small></small>元素

      着重<strong>

      斜体<em></em>

      <b><i>标签

   对齐
    
       text-left、text-center、text-right、text-justify、text-nowrap

   改变大小写

       lowercased text、uppercased tedxt、Capitalized、
   
   缩略语
   当鼠标悬停在缩写和缩写词上面时就会显示完整的内容，Bootstrap实现了对Html的<abbr>元素的增强样式。缩略语元素带有title属性，外观表现为较浅的虚线框，鼠标移至上面会变成带有问号的指针，如果想看完整的内容，可以把鼠标悬挂在缩略语，但同时包含title属性。

     <abbr title="attribute">attr</abbr>

      首字母缩略语（为其添加.initialism）
     
      <abbr title="attribute" class="initialism">HTML</abbr>

      地址（让联系信息以最接近日常使用的格式呈现。在每行结尾添加<br>）

   引用（在文档中引用其他来源的内容）

   默认样式的引用：将任何HTML元素包裹在<blockquote>中即可表现为引用样式。对于直接引用，我们建议用<p>标签

     <blockquote>
      <p>lorem ipsum dolor sit amet</p>
      <footer>Someone famous in<cite title="Source Title">source title</cite></footer>
     </blockquote>

     <blockquote class="blockquote-reverse">
      ...
     </blockquote>
  
   内联列表：通过设置display: inline-block;并且添加少量的内补（padding）将所有的元素放置于一行

    各种列表：
    <ul class="list-inline">
		<li>...</li>
    </ul>

    <dl class=".dl-horizontal">(.dl-horizontal)
    	<dt>...</dt>
        <dd>...</dd>
    </dl>

    自动截断（通过text-overflow属性，水平排列的描述列表将会截断左侧太长的短语。在较窄的视口（viewport）内，列表将变为默认堆叠的排列方式）

#####代码
  
    内联代码：通过<code>标签包裹内联样式的代码片段

    用户输入：通过<kdb>标签标记用户通过键盘输入的内容

    代码块：<pre>  .pre-scrollable类
    
    变量：通过<var>标签标记
    
    程序输出：通过<samp>标签来标记程序输出的内容
#####表格

    <table>标签 .table 类可以为其赋予基本的样式 少量的内补 padding 和水平方向的分割线

    .table-striped类可以给<tbody>之内的每一行增加斑马条纹样式
    <table class="table table-striped">

    带边框的表格：.table-bordered类为表格和其中的每个单元格增加边框
    <table class="table table-bordered">

    鼠标悬停：.table-hover类可以让<tbody>中的每一行对鼠标的悬停状态作出相应

    紧缩表格.table-condensed让表格更加紧凑，单元格中的内补（padding）均会减半<table class="table table-condensed">

    状态类： .active .success .info .warning .danger

    响应式表格：将任何 .table 元素包裹在 .table-responsive 元素内，即可创建响应式表格，其会在小屏幕设备上（小于768px）水平滚动。当屏幕大于 768px 宽度时，水平滚动条消失

#####表单
   所有设置了单独的表单控件会被自动的赋予一些全局样式。所有设置了.form-control类的元素都将被默认设置宽度属性为width: 100%; 将label元素和前面提到的控件包裹在.form-group中可以获得最好的排列

     不要将表单组合输入框混合使用，建议将输入框嵌套到表单组中使用

     <form role="form">
     	<div class="form-group">
    		<label for="exampleInputEmail1">Email address</label><input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email"></div>
       </form>

   内联表单：  为<form>元素添加.form-inline类可使内容左对齐并且表现为inline-bock级别的控件
   一定要添加label标签。对于这些内联表单，你可以通过为label设置.sr-only类将其隐藏。

       <form class="form-inline" role="form">
       		<div class="form-group">
   			 <label class="sr-only" for="exampleInputEmail2">Email address</label>
   			 <input type="email" class="form-control" id="exampleInputEmail2" placeholder="Enter email">
  	   </div>
   
   支持的控件：表单布局实例中展示了其所支持的标准表单控件
   输入框：包括大部分的表单控件、文本输入控件、还支持所有的HTML5类型的输入的控件

       <input type="text" class="form-control" placeholder="Text input">

   文本域，支持多行文本的表单控件，可根据需要改变rows属性
       
     <textarea class="form-control" rows="3"></textarea>

   多选和单选框：
   多选框checkbox用于选择列表中的一个或者多个选项，单选radio用于从多个选项中只能选择一个。设置了disabled属性的单选或多选框都能被赋予合适的样式。对于多选或者单选框的联合使用的<label>标签请将 .disabled 类赋予 .radio、.radio-inline、.checkbox、.checkbox-inline 或 <fieldset>

      <div class="checkbox">
      	<label>
    		<input type="checkbox" value="">
    		Option one is this and that&mdash;be sure to include why it's great
  		</label>
		</div>
		<div class="checkbox disabled">
  			<label>
    		<input type="checkbox" value="" disabled>
    		Option two is disabled
  			</label>
		</div>

   内联单选和多选框（.checkbox-inline或.radio-inline类应用到一系列的多选框（checkbox）或单选框（radio）控件上），可以使这些控件排列在一行。


        <label class="checkbox-inline">
  		 	<input type="checkbox" id="inlineCheckbox1" value="option1"> 1
	    </label>
		<label class="checkbox-inline">
  		<input type="checkbox" id="inlineCheckbox2" value="option2"> 2
  	    </label>

   下拉列表(select)使用默认选项或添加 multiple属性可以同时显示多个选项
  
        <select multiple class="form-control">
  			<option>1</option>
  			<option>2</option>
  			<option>3</option>
  			<option>4</option>
  			<option>5</option>
		</select>

   静态控件：在表单中如果需要为一行纯文本和label元素放置于同一行，为<p>元素添加.form-control-static

        <form class="form-horizontal" role="form">
  			<div class="form-group">
    		<label class="col-sm-2 control-label">Email</label>
    		<div class="col-sm-10">
      		<p class="form-control-static">email@example.com</p>
    		</div>
  			</div>
        </form>

   输入框焦点：（我们将某些表单控件的默认outline样式移除，然后对：focus状态赋予box-shadow属性）

   被禁用的输入框：为输入框设置disabled属性可以防止用户输入
   
		<input class="form-control" id="disabledInput" type="text" placeholder="Disabled input here..." disabled>

   被禁用的fieldset（为<fieldset>设置disabled属性，可以禁用其所有的控件）

        <form role="form">
  			<fieldset disabled>
   			 <div class="form-group">
      		<label for="disabledTextInput">Disabled input</label>
      		<input type="text" id="disabledTextInput" class="form-control" placeholder="Disabled input">
    		</div>
			</fieidest>
		</form>

   只读输入框为输入框设置readonly属性可以禁止用户输入，并且输入框的样式也是禁用状态
        <input class="form-control" type="text" placeholder="Readonly input here…" readonly>

   校验状态（bootstrap对表单控件的校验状态）如error、warning、success状态.has-warning、.has-error 或 .has-success 类到这些控件的父元素即可。任何包含在此元素之内的 .control-label、.form-control 和 .help-block 元素都将接受这些校验状态的样式。

         <div class="form-group has-success">
  			<label class="control-label" for="inputSuccess1">Input with success</label>
  			<input type="text" class="form-control" id="inputSuccess1">
		 </div>

   添加额外的图标（设置相应的.has-feedback类并添加正确的图标即可）
   图标、label和输入控件组，不希望展示label标签，可以添加.sr-only类来实现
        
         <div class="form-group has-success has-feedback">
  			<label class="control-label" for="inputSuccess2">Input with success</label>
  			<input type="text" class="form-control" id="inputSuccess2">
 			 <span class="glyphicon glyphicon-ok form-control-feedback"></span>
		 </div>

   为水平排列的表单和内联表单设置可选的图标

         <form class="form-horizontal" role="form">
  			<div class="form-group has-success has-feedback">
    		<label class="control-label col-sm-3" for="inputSuccess3">Input with success</label>
   			 <div class="col-sm-9">
      		<input type="text" class="form-control" id="inputSuccess3">
      		<span class="glyphicon glyphicon-ok form-control-feedback"></span>
   			 </div>
  			</div>
			</form>

   控件的尺寸：通过.input-lg类似的类可以为控件设置高度，通过.col-lg-*类似的类可以为控件设置宽度。
   
            <input class="form-control input-lg" type="text" placeholder=".input-lg">
			<input class="form-control" type="text" placeholder="Default input">
			<input class="form-control input-sm" type="text" placeholder=".input-sm">

   水平排列的表单组的尺寸
   通过添加.form-group-lg或.form-horizontal包裹的label元素和表单控件快速设置尺寸。
    
            <form class="form-horizontal" role="form">
  			<div class="form-group form-group-lg">
    		<label class="col-sm-2 control-label" for="formGroupInputLarge">Large label</label>
    			<div class="col-sm-10">
      		<input class="form-control" type="text" id="formGroupInputLarge" placeholder="Large input">
    		</div>
  			</div>
	
   调整（column）尺寸，用栅格系统中的列（column）包裹输入框或其任何父元素，都可很容易为其设置宽度
     
      		<div class="row">
  			<div class="col-xs-2">
   			 <input type="text" class="form-control" placeholder=".col-xs-2">
  			</div>
#####按钮
   预定义样式：
       
			<button type="button" class="btn btn-default">Default</button>	
			<button type="button" class="btn btn-primary">Primary</button>	
			<button type="button" class="btn btn-success">Success</button>
			<button type="button" class="btn btn-info">Info</button>
			<button type="button" class="btn btn-warning">Warning</button>
			<button type="button" class="btn btn-danger">Danger</button>
			<button type="button" class="btn btn-link">Link</button>

   尺寸：.btn-lg、.btn-sm 或 .btn-xs 可以获得不同尺寸的按钮

			<button type="button" class="btn btn-primary btn-lg">Large button</button>

   通过给按钮添加 .btn-block 类可以将其拉伸至父元素100%的宽度，而且按钮也变为了块级（block）元素

			<button type="button" class="btn btn-primary btn-lg btn-block">Block level button</button>

   激活状态 ：active状态实现的 <a> 通过.active类实现
   button元素 由于：active是伪状态，因此无需额外添加

   			
			<button type="button" class="btn btn-primary btn-lg active">Primary button</button>

			<a href="#" class="btn btn-primary btn-lg active" role="button">Primary link</a>

   禁用状态：通过按钮的背景设置opacity就可以呈现出无法点击的效果
   button 元素 为 <button> 元素添加 disabled 属性，使其表现出禁用状态

    		<button type="button" class="btn btn-lg btn-primary" disabled="disabled">Primary button</button>

			<a href="#" class="btn btn-primary btn-lg disabled" role="button">Primary link</a>

   按钮类：为 <a>、<button> 或 <input> 元素应用按钮类

			<a class="btn btn-default" href="#" role="button">Link</a>
			<button class="btn btn-default" type="submit">Button</button>
			<input class="btn btn-default" type="button" value="Input">
			<input class="btn btn-default" type="submit" value="Submit">

#####图片

   响应式图片 为图片添加.img-responsive

			<img src="..." class="img-responsive" alt="Responsive image">

   图片形状：通过为 <img> 元素添加以下相应的类，可以让图片呈现不同的形状

			<img src="..." alt="..." class="img-rounded">
			<img src="..." alt="..." class="img-circle">
			<img src="..." alt="..." class="img-thumbnail">

#####辅助类：
   Contextual colors

			<p class="text-muted">...</p>
			<p class="text-primary">...</p>
			<p class="text-success">...</p>
			<p class="text-info">...</p>
			<p class="text-warning">...</p>
			<p class="text-danger">...</p>

   Contextual backgrounds

			<p class="bg-primary">...</p>
			<p class="bg-success">...</p>
			<p class="bg-info">...</p>
			<p class="bg-warning">...</p>
			<p class="bg-danger">...</p>

   关闭按钮：

			<button type="button" class="close"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>

   三角符号


			<span class="caret"></span>

   快速浮动

			<div class="pull-left">...</div>
			<div class="pull-right">...</div>

   Center content blocks
			
			<div class="center-block">...</div>
			// Classes
			.center-block {
  			display: block;
  			margin-left: auto;
  			margin-right: auto;
			}

			// Usage as mixins
			.element {
  			.center-block();
			}

   Clearfix

		   <div class="clearfix">...</div>
			
			.clearfix() {
 			 &:before,
  				&:after {
    			content: " ";
   				 display: table;
  					}
  			&:after {
   				 clear: both;
  				}
				}

			// Usage as a Mixin
			.element {
  				.clearfix();
				}

   Showing and hiding content

			<div class="show">...</div>
			<div class="hidden">...</div>

			.show {
  				display: block !important;
				}
			.hidden {
  				display: none !important;
  				visibility: hidden !important;
				}
			.invisible {
  				visibility: hidden;
				}

			// Usage as mixins
			.element {
  				.show();
				}
			.another-element {
  				.hidden();
				}

   Screen reader and keyboard navigation content

			<a class="sr-only sr-only-focusable" href="#content">Skip to main content</a>

			.skip-navigation {
  			.sr-only();
  			.sr-only-focusable();
			}

   Image replacement

			<h1 class="text-hide">Custom heading</h1>

			// Usage as a Mixin
			.heading {
  			.text-hide();
			}

#####响应式工具
#####使用less

###组件

    Glyphicons 字体图标
    所有的图标都需要一个基类和对应每个图标的类。注意，为了设置正确的内补（padding），务必在图标和文本之间添加一个空格

    不要和其他组件混合使用
    图标类不能和其它组件直接联合使用。它们不能在同一个元素上与其他类共同存在。应该创建一个嵌套的 <span> 标签，并将图标类应用到这个 <span> 标签上

    只对内容为空的元素起作用
    图标类只能应用在不包含任何文本内容或子元素的元素上。

    改变图标字体文件的位置
    
    <span class="glyphicon glyphicon-search"></span>
    
    可以把他们应用到按钮、工具条中的按钮组、导航或输入框等地方
    button type="button" class="btn btn-default btn-lg">
    <span class="glyphicon glyphicon-star"></span> Star
    </button>
#####下拉菜单

    将下拉菜单触发器和下拉菜单都包裹在.dropdown里，或者另一个声明了position: relative；的元素。
	 <div class="dropdown">
     	<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
    		Dropdown
    	 <span class="caret"></span>
  	    </button>

		<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
    	<li role="presentation"><a role="menuitem" tabindex="-1" href="#">Action</a></li>
    	<li role="presentation"><a role="menuitem" tabindex="-1" href="#">Another action</a></li>
    	<li role="presentation"><a role="menuitem" tabindex="-1" href="#">Something else here</a></li>
    	<li role="presentation"><a role="menuitem" tabindex="-1" href="#">Separated link</a></li>
 		 </ul>
		</div>

   对齐：B默认情况下，下拉菜单自动沿着父元素的上沿和左侧被定位为 100% 宽度。 为 .dropdown-menu 添加 .dropdown-menu-right 类可以让菜单右对齐
     
	<ul class="dropdown-menu dropdown-menu-right" role="menu" aria-labelledby="dLabel">
     ...
    </ul>

标题：在任何下拉子菜单中均可以通过添加标题来标明一组动作

		<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu2">
  		...
  		<li role="presentation" class="dropdown-header">Dropdown header</li>
 		 ...
		</ul>

分割线：为下拉菜单添加一条分割线，用于将多个链接分组

		<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenuDivider">
  		...
  		<li role="presentation" class="divider"></li>
 		 ...
		</ul>

禁用菜单项：为下拉菜单中的<li>添加.disabled类，从而禁用相应的菜单项

		<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu3">
  		<li role="presentation"><a role="menuitem" tabindex="-1" href="#">Regular link</a></li>
  		<li role="presentation" class="disabled"><a role="menuitem" tabindex="-1" href="#">Disabled link</a></li>
  		<li role="presentation"><a role="menuitem" tabindex="-1" href="#">Another link</a></li>
		</ul>

#####按钮组（通过按钮组容器把一组按钮放在同一行里。通过与按钮插件联合使用，可以设置为单选框或多选框的样式和行为）

   
		<div class="btn-group">
  		<button type="button" class="btn btn-default">Left</button>
  		<button type="button" class="btn btn-default">Middle</button>
  		<button type="button" class="btn btn-default">Right</button>
		</div>
   
按钮工具栏（把一组 <div class="btn-group"> 组合进一个 <div class="btn-toolbar"> 中就可以做成更复杂的组件）
		<div class="btn-toolbar" role="toolbar">
  		<div class="btn-group">...</div>
  		<div class="btn-group">...</div>
  		<div class="btn-group">...</div>
		</div>

尺寸：（只要给 .btn-group 加上 .btn-group-* 类，就省去为按钮组中的每个按钮都赋予尺寸类了）

		<div class="btn-group btn-group-lg">...</div>
		<div class="btn-group">...</div>
		<div class="btn-group btn-group-sm">...</div>
		<div class="btn-group btn-group-xs">...</div>

嵌套：（想要把下拉菜单混合到一系列按钮中，只须把 .btn-group 放入另一个 .btn-group 中）

		<div class="btn-group">
  		 <button type="button" class="btn btn-default">1</button>
 		 <button type="button" class="btn btn-default">2</button>

  		 <div class="btn-group">
   		 <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
     	 Dropdown
       	<span class="caret"></span>
    	</button>
    	<ul class="dropdown-menu" role="menu">
      	<li><a href="#">Dropdown link</a></li>
      	<li><a href="#">Dropdown link</a></li>
    	</ul>
  		</div>
		</div>

垂直排列：（让一组按钮垂直堆叠排列显示而不是水平排列。分列式按钮下拉菜单不支持这种方式）

	   <div class="btn-group-vertical">
  		...
	   </div> 

两端对齐排列的按钮组：（让一组按钮拉长为相同的尺寸，填满父元素的宽度。对于按钮组中的按钮式下拉菜单也同样适用）    

	  由于对两端对齐的按钮组使用了特定的 HTML 和 CSS （即 display: table-cell），两个按钮之间的边框叠加在了一起。在普通的按钮组中，margin-left: -1px 用于将边框重叠，而没有删除任何一个按钮的边框。然而，margin 属性不支持 display: table-cell。因此，根据你对 Bootstrap 的定制，你可以删除或重新为按钮的边框设置颜色。

      关于 <a> 元素
      只须将一系列 .btn 元素包裹到 .btn-group.btn-group-justified 中即可。

		<div class="btn-group btn-group-justified">
 		 ...
		</div>

    关于<button> 元素

    为了将 <button> 元素用于两端对齐的按钮组中，必须将每个按钮包裹进一个按钮组中you must wrap each button in a button group。

	<div class="btn-group btn-group-justified">
  		<div class="btn-group">
    	<button type="button" class="btn btn-default">Left</button>
   </div>
	</div>

	按钮式下拉菜单
	把任意一个按钮放入 .btn-group 中，然后加入适当的菜单标签，就可以让按钮作为菜单的触发器了。

    插件依赖
    按钮式下拉菜单依赖下拉菜单插件 ，因此需要将此插件包含在你所使用的 Bootstrap 版本中

	单按钮下拉菜单
	只要改变一些基本的标记，就能把按钮变成下拉菜单的开关

		<div class="btn-group">
  		<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
   		 Action <span class="caret"></span>
  		</button>
  		<ul class="dropdown-menu" role="menu">
   		 <li><a href="#">Action</a></li>
    		<li><a href="#">Another action</a></li>
    		<li><a href="#">Something else here</a></li>
    		<li class="divider"></li>
    		<li><a href="#">Separated link</a></li>
  		</ul>
		</div>

	分裂式按钮下拉菜单
	相似地，分裂式按钮下拉菜单也需要同样的改变一些标记，但只是多一个分开的按钮
	
	<!-- Split button -->
	<div class="btn-group">
 	 <button type="button" class="btn btn-danger">Action</button>
  	<button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown">
    <span class="caret"></span>
    <span class="sr-only">Toggle Dropdown</span>
  	</button>
  	<ul class="dropdown-menu" role="menu">
    <li><a href="#">Action</a></li>
    <li><a href="#">Another action</a></li>
    <li><a href="#">Something else here</a></li>
    <li class="divider"></li>
    <li><a href="#">Separated link</a></li>
 	 </ul>
	</div>

尺寸(按钮式下拉菜单适用所有尺寸的按钮。)
	
		<div class="btn-group">
  		<button class="btn btn-default btn-lg dropdown-toggle" type="button" data-toggle="dropdown">
    		Large button <span class="caret"></span>
 		 </button>
  		<ul class="dropdown-menu" role="menu">
    		...
  		</ul>
		</div>

向上弹出式菜单(给父元素添加 .dropup 类就能使触发的下拉菜单朝上方打开)

		<div class="btn-group dropup">
 		 <button type="button" class="btn btn-default">Dropup</button>
  		 <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
    	 <span class="caret"></span>
   		 <span class="sr-only">Toggle Dropdown</span>
  		</button>
  		<ul class="dropdown-menu" role="menu">
   	 <!-- Dropdown menu links -->
 		 </ul>
		</div>

   
     输入框组(通过在文本输入框 <input> 前面、后面或是两边加上文字或按钮，可以实现对表单控件的扩展。为 .input-group 赋予 .input-group-addon 类，可以给 .form-control 的前面或后面添加额外的元素)
	
	 只支持文本输入框 <input>

		<div class="input-group">
  		<span class="input-group-addon">@</span>
  		<input type="text" class="form-control" placeholder="Username">
		</div>

尺寸(为 .input-group 添加相应的尺寸类，其内部包含的元素将自动调整自身的尺寸。不需要为输入框组中的每个元素重复地添加控制尺寸的类)

		<div class="input-group input-group-lg">
 		 <span class="input-group-addon">@</span>
  			<input type="text" class="form-control" placeholder="Username">
		</div>

作为额外元素的多选框和单选框(可以将多选框或单选框作为额外元素添加到输入框组中)

		<div class="row">
  		<div class="col-lg-6">
    		<div class="input-group">
     		 <span class="input-group-addon">
        	<input type="checkbox">
      	</span>
     	 <input type="text" class="form-control">
    	</div><!-- /input-group -->
  		</div><!-- /.col-lg-6 -->

作为额外元素的按钮(为输入框组添加按钮需要额外添加一层嵌套，不是 .input-group-addon，而是添加 .input-group-btn 来包裹按钮元素。由于不同浏览器的默认样式无法被统一的重新赋值，所以才需要这样做)

		<div class="row">
  			<div class="col-lg-6">
    		<div class="input-group">
      		<span class="input-group-btn">
        	<button class="btn btn-default" type="button">Go!</button>
      	</span>
      	<input type="text" class="form-control">
    	</div><!-- /input-group -->
  		</div><!-- /.col-lg-6 -->

作为额外元素的按钮式下拉菜单

		<div class="row">
  			<div class="col-lg-6">
    		<div class="input-group">
      		<div class="input-group-btn">
        	<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">Action <span class="caret"></span></button>
        	<ul class="dropdown-menu" role="menu">
          	<li><a href="#">Action</a></li>
          	<li><a href="#">Another action</a></li>
          	<li><a href="#">Something else here</a></li>
         	 <li class="divider"></li>
         	 <li><a href="#">Separated link</a></li>
        	</ul>
      	</div><!-- /btn-group -->
     	 <input type="text" class="form-control">
    	</div><!-- /input-group -->
  		</div><!-- /.col-lg-6 -->

作为额外元素的分裂式按钮下拉菜单

		<div class="input-group">
  			<div class="input-group-btn">
    		<!-- Button and dropdown menu -->
  		</div>
  		<input type="text" class="form-control">
		</div>

导航(Bootstrap 中的导航组件都依赖同一个 .nav 类，状态类也是共用的。改变修饰类可以改变样式)

		注意 .nav-tabs 类依赖 .nav 基类
		<ul class="nav nav-tabs" role="tablist">
  		<li role="presentation" class="active"><a href="#">Home</a></li>
  		<li role="presentation"><a href="#">Profile</a></li>
  		<li role="presentation"><a href="#">Messages</a></li>
		</ul>

		对于带有可切换标签区域的标签页，必须使用 标签页的 JavaScript 插件。

胶囊式标签页(HTML 标记相同，但使用 .nav-pills 类)

		<ul class="nav nav-pills" role="tablist">
  		<li role="presentation" class="active"><a href="#">Home</a></li>
  		<li role="presentation"><a href="#">Profile</a></li>
  		<li role="presentation"><a href="#">Messages</a></li>
		</ul>

胶囊是标签页也是可以垂直方向堆叠排列的。只需添加 .nav-stacked 类。

		<ul class="nav nav-pills nav-stacked" role="tablist">
            ...
		</ul>

两端对齐的标签页( .nav-justified 类可以很容易的让标签页或胶囊式标签呈现出同等宽度。在小屏幕上，导航链接呈现堆叠样式)

		<ul class="nav nav-tabs nav-justified" role="tablist">
  			...
		</ul>
		<ul class="nav nav-pills nav-justified" role="tablist">
 		 ...
		</ul>

禁用的链接

		对任何导航组件（标签页、胶囊是标签页），都可以添加 .disabled 类，从而实现链接为灰色且没有鼠标悬停效果

		链接功能不受到影响
		这个类只改变 <a> 的外观，不改变功能。可以自己写 JavaScript 禁用这里的链接

		<ul class="nav nav-pills" role="tablist">
  			...
 		 <li role="presentation" class="disabled"><a href="#">Disabled link</a></li>
  		...
		</ul>	

添加下拉菜单(用一点点额外 HTML 代码并加入下拉菜单插件的 JavaScript 插件即可。)

		<ul class="nav nav-tabs" role="tablist">
 		 ...
  		<li role="presentation" class="dropdown">
   		 <a class="dropdown-toggle" data-toggle="dropdown" href="#">
     	 Dropdown <span class="caret"></span>
    	</a>
    	<ul class="dropdown-menu" role="menu">
     	 ...
    	</ul>
 		 </li>
 		 ...
		</ul>

带下拉菜单的胶囊式标签页

		<ul class="nav nav-pills" role="tablist">
  		...
  		<li role="presentation" class="dropdown">
   		 <a class="dropdown-toggle" data-toggle="dropdown" href="#">
      	Dropdown <span class="caret"></span>
   		 </a>
    		<ul class="dropdown-menu" role="menu">
     		 ...
    		</ul>
  		</li>
  		...
		</ul>

导航条（默认样式的导航条）（导航条是在您的应用或网站中作为导航页头的响应式基础组件。它们在移动设备上可以折叠（并且可开可关），且在视口（viewport）宽度增加时逐渐变为水平展开模式）

		<nav class="navbar navbar-default" role="navigation">
  			<div class="container-fluid">
    		<!-- Brand and toggle get grouped for better mobile display -->
    		<div class="navbar-header">
      		<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
       		 <span class="sr-only">Toggle navigation</span>
       		 <span class="icon-bar"></span>
        		<span class="icon-bar"></span>
        		<span class="icon-bar"></span>
      		</button>
      		<a class="navbar-brand" href="#">Brand</a>
    		</div>

插件依赖
此响应式导航条依赖折叠（collapse）插件，你所使用的 Bootstrap 版本中应该包含此插件（为了增强可访问性，务必给每个导航条加上 role="navigation" 属性）

表单（将表单放置于 .navbar-form 之内可以呈现很好的垂直对齐，并在较窄的视口（viewport）中呈现折叠状态。 使用对齐选项可以规定其在导航条上出现的位置）

		<form class="navbar-form navbar-left" role="search">
  		<div class="form-group">
    	<input type="text" class="form-control" placeholder="Search">
  		</div>
  		<button type="submit" class="btn btn-default">Submit</button>
		</form>

为输入框添加 label 标签
如果你没有为输入框添加 label 标签，屏幕阅读器将会遇到问题。对于导航条内的表单，可以通过添加 .sr-only 类隐藏 label 标签


    按钮：（对于不包含在 <form> 中的 <button> 元素，加上 .navbar-btn 后，可以让它在导航条里垂直居中）

	<button type="button" class="btn btn-default navbar-btn">Sign in</button>

文本：（把文本包裹在 .navbar-text中时，为了有正确的行距和颜色，通常使用 <p> 标签）

		<p class="navbar-text">Signed in as Mark Otto</p>

非导航的链接：（ .navbar-link 类可以让链接有正确的默认颜色和反色设置）

		<p class="navbar-text navbar-right">Signed in as <a href="#" class="navbar-link">Mark Otto</a></p>

组件排列（通过添加 .navbar-left 和 .navbar-right 工具类让导航链接、表单、按钮或文本对齐。两个类都会通过 CSS 设置特定方向的浮动样式）（这些类是 .pull-left 和 .pull-right 的 mixin 版本，但是他们被限定在了媒体查询（media query）中，这样可以更容易的在各种尺寸的屏幕上处理导航条组件）

固定在顶部（添加 .navbar-fixed-top 类可以让导航条固定在顶部，还可包含一个 .container 或 .container-fluid 容器，从而让导航条居中，并在两侧添加内部（padding））

		<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
  			<div class="container">
   			 ...
  			</div>
			</nav>

    需要为 body 元素设置内部（padding）
	body { padding-top: 70px; }