# Light-up-your-starry-sky
This is a fun game！
<html>
  <a href="https://tmxjiayou.github.io/Light-up-your-starry-sky/index.html">点我看效果</a>
</html>


# 设计思路
  
	首先在index.html页面中新增多个div标签，包括小游戏的主界面div，该div块中嵌套了“步数div块”，“游戏界面div块”，“结束界面div块”。当点击界面中的灯泡时，选择“步数div块”的id，通过
	 ``` javascript
		@requires_authorization
		Moves++;
		$('#movecount').text(Moves);  // 步数累计并更新    用来显示已用的步数。
	 ```
	进行步数的增加。
	游戏开始前需初始化界面，需要随机的给状态位数组赋给0，1值，然后在给不同的状态位赋值相应的图片路径。
    点击某个灯泡图片时，该图片以及周围上下左右的四个灯泡图片均会发生变化，若之前为亮，则点击之后，变为熄灭，通过标志位取反来实现。定义两个数组，一个为状态数组，一个为图片数组，假设当前是3*3的窗口，一共9章图片，图片数组对应索引为0-8，状态数组中为3*3的矩阵，当点击灯泡图片发生状态变化后，状态数组中对应位置的0，1会发生变化，将变化后的状态数组重新与灯泡数组中的图片进行对应，不同的状态对应不同的图片。

### div介绍
	div标签可以把文档分割为独立的、不同的部分。它可以用作严格的组织工具，并且不使用任何格式与其关联。  在html中常用于布局、定位、区分。现在大多数页面都使用的DIV+CSS布局。
	<div> 可定义文档中的分区或节（division/section）。
	<div> 标签可以把文档分割为独立的、不同的部分。它可以用作严格的组织工具，并且不使用任何格式与其关联。
	如果用 id 或 class 来标记 <div>，那么该标签的作用会变得更加有效。

	用法:
	<div> 是一个块级元素。这意味着它的内容自动地开始一个新行。实际上，换行是 <div> 固有的唯一格式表现。可以通过 <div> 的 class 或 id 应用额外的样式。
	不必为每一个 <div> 都加上类或 id，虽然这样做也有一定的好处。
	可以对同一个 <div> 元素应用 class 或 id 属性，但是更常见的情况是只应用其中一种。这两者的主要差异是，class 用于元素组（类似的元素，或者可以理解为某一类元素），而 id 用于标识单独的唯一的元素。