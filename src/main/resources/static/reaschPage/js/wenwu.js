/**
 * Created by Administrator on 2018/7/14.
 */

$(function () {

  var $building1 = $(".building1");
  $(".building1 .button").on("click", function () {
    console.log(1111);

    if ($building1.hasClass('now')) {
      $building1.removeClass('now');
    } else {
      $building1.addClass('now');
    }
  })

  var $pii1 = $(".pii1");
  $(".pii1").mouseenter(function () {
    $(this).css({
      "top": "28px",
      "left": "58px"
    });
  })
  $(".pii1").mouseleave(function () {
    $(this).css({
      "top": "38px",
      "left": "68px"
    });
  })
  var $pii2 = $(".pii2");
  $(".pii2").mouseenter(function () {
    $(this).css({
      "top": "28px",
      "left": "58px"
    });
  })
  $(".pii2").mouseleave(function () {
    $(this).css({
      "top": "38px",
      "left": "68px"
    });
  })
  var $pii3 = $(".pii3");
  $(".pii3").mouseenter(function () {
    $(this).css({
      "top": "28px",
      "left": "58px"
    });
  })
  $(".pii3").mouseleave(function () {
    $(this).css({
      "top": "38px",
      "left": "68px"
    });
  })
  var $pii4 = $(".pii4");
  $(".pii4").mouseenter(function () {
    $(this).css({
      "top": "28px",
      "left": "58px"
    });
  })
  $(".pii4").mouseleave(function () {
    $(this).css({
      "top": "38px",
      "left": "68px"
    });
  })
  var $pii5 = $(".pii5");
  $(".pii5").mouseenter(function () {
    $(this).css({
      "top": "28px",
      "left": "58px"
    });
  })
  $(".pii5").mouseleave(function () {
    $(this).css({
      "top": "38px",
      "left": "68px"
    });
  })

  $(function () {
    //(1)�Ȼ�ȡԪ�أ���Ӷ�ʱ�ֲ�
    var timeID = setInterval(function () {
      if ($("#aa").css("left") == "-3774px") {
        $("#aa").css("left", "-1258px");
      }
      $("#aa").stop(true, false).animate({"left": "-=1258px"}, 2000);

    }, 3000);
    $("#aa").mouseenter(function () {
      clearInterval(timeID);
    });

    $("#aa").mouseleave(function () {
      timeID = setInterval(function () {
        if ($("#aa").css("left") == "-3774px") {
          $("#aa").css("left", "-1258px");
        }
        $("#aa").stop(true, false).animate({"left": "-=1258px"}, 1000);

      }, 3000)
    });
    ;

  });
});

window.onload = function () {
  var wrap = document.getElementsByClassName("wrap");
  var tabarList = document.getElementsByClassName('tabar')[0];
  var aList = tabarList.getElementsByTagName("a");
  var conList = document.getElementsByClassName("con");

  for (var i = 0; i < aList.length; i++) {
    aList[i].setAttribute('index', i);
    aList[i].onclick = function () {
      this.className = "current";
      var index = this.getAttribute("index");

      conList[index].style.display = 'block';//���ö�Ӧ�±��div��ʾ
      aList[index].style.backgroundPositionY = "-45px";

      //����˼��ȥ��������ť��ʽ �Ͷ�Ӧ�±��div����
      for (var j = 0; j < aList.length; j++) {
        if (aList[j] != this) {
          aList[j].className = '';
          conList[j].style.display = 'none';
          aList[j].style.backgroundPositionY = "-7px";
        }
      }
    }
  }
}
//  //////////////////////////////////////

