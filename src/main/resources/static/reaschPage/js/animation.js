/*
** Create by 张晓坤 on 2018/7/2
* 动画封装
*/

/**匀速移动函数
 *
 * @param objc  要移动的元素
 * @param target  要移动的距离
 */
function animationMove(objc, target) {
  //每一次点击按钮的时候，无条件的清除当前的定时
  //如果这个元素以前有定时器，则先清除以前的定时器
  clearInterval(objc.timeID);
  //如果是全局变量timeID来记录定时器，则只能存储一个定时器，无法让多个元素同时移动
  /*解决方案：每一个元素移动时，给这个元素动态添加一个属性来记录自己的定时器，到达终点后自己移除
  这样就可以保证每一个元素的移动定时器都是独立的，互不干扰
   */
  objc.timeID = setInterval(function () {
    //1.获取元素当前位置
    var currentLeft = objc.offsetLeft;
    //判断元素是从左往右还是从右往左
    /*这行代码意思：用一个isLeft变量来保存用户移动方向   true:从左往右  false：从右往左
    三元表达式：  如果当前位置< 目标位置  返回true
     */
    var isLeft = currentLeft < target ? true : false;
    //2.元素移动
    if (isLeft) {//从左往右
      currentLeft += 20;
    } else {//从右往左
      currentLeft -= 20;
    }
    /*isLeft?currentLeft<target:currentLeft>target
    如果ifLeft为true，则返回currentLeft<target 条件表达式的结果
    如果ifLeft为false，则返回currentLeft>target条件表达式的结果
     */
    if (isLeft ? currentLeft < target : currentLeft > target) {//没有到达目的地，则移动
      objc.style.left = currentLeft + 'px';//offsetLeft只能读取不能设置，设置还是用点语法获取style
    } else {//到达目的低，结束定时器，位置复位
      clearInterval(objc.timeID);
      objc.style.left = target + 'px';
    }

  }, 10);
}
