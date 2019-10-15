$(function () {
  //$(".top .header #ul1>li").mouseenter(function () {
  //    alert("hahhahah");
  //});
  $("#ggxy1").show(2000);
  $(".main .abstract .switch img#ggxy01").show(2000)
  $("#ggxy2").hide();
  $(".main .abstract .switch img#ggxy11").hide(2000)

  $(".main .abstract .switch").click(function () {
    //�ʹ�ѧԺ��ͼ���ַ��Ϊ����ѡ����ʾ������Ϊ�ϻ���Ϊ��
    $("#ggxy1").toggle(2000);
    $(".main .abstract .switch img#ggxy01").toggle(2000)
    $("#ggxy2").toggle(2000);
    $(".main .abstract .switch img#ggxy11").toggle(2000)

  })
});
$(function () {
  $(".main1 div.cooperation #wao").show(10)
  $(".main1 div.cooperation #wao1").hide(10)
  $(".main1 div.cooperation #wao2").hide(10)
  var index = 0;
  $(" .main1 div.cooperation .btn #btn1").click(function () {
    index++;
    if (index == 3) {
      index = 0;
    }
    $(".main1 div.cooperation .lala").eq(index).fadeIn(10).siblings(
        ".lala").fadeOut(10)
  })
  $(" .main1 div.cooperation .btn #btn2").click(function () {
    index--;
    if (index == -1) {
      index = 2;
    }
    $(".main1 div.cooperation .lala").eq(index).fadeIn(10).siblings(
        ".lala").fadeOut(10)
  })
})

$(function () {
  $("#lunboo1").click(function () {
    $("#xx").animate({
      "left": -1252
    }, 200)
  })
  $("#lunbo").click(function () {
    $("#xx").animate({
      "left": 0
    }, 200)
  })
})
$(function () {
  $(".main4 #last ul li").mouseenter(function () {
    $(this).children("a").animate({"top": -10}, 1000)
  })
  $(".main4 #last ul li").mouseleave(function () {
    $(this).children("a").animate({"top": 0}, 1000)
  })
})
//�������߽��������ͼ����ͼƬ����������
