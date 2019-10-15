/**
 * Created by as on 2018/7/18.
 */
//�ֲ�ͼ
var frame = document.getElementsByClassName('frame')[0];//�ֲ�ͼ�����
var frame_ul = frame.children[0];//ͼƬ�б�ul��ǩ
var focus_nav = document.getElementsByClassName('focus_nav')[0];//����
var ol = focus_nav.children[0];
var index = 0;

function nexpage() {

  if (index == frame_ul.children.length - 1) {
    index = 0;
    frame_ul.style.left = '0px';
  }
  index++;
  console.log(index);
  animationMove(frame_ul, -index * frame.offsetWidth);
  for (var i = 0; i < ol.children.length; i++) {
    if (i == index) {
      ol.children[i].className = 'current';
    } else {
      ol.children[i].className = '';
    }
  }
  if (index == frame_ul.children.length - 1) {
    ol.children[0].className = 'current';
  }
}

setInterval(nexpage, 3000);
//ҳ����
for (var i = 0; i < ol.children.length; i++) {
  ol.children[i].setAttribute('yemaIndex', i);
  ol.children[i].onclick = function () {
    var yemaIndex = this.getAttribute('yemaIndex');
    index = yemaIndex;
    animationMove(frame_ul, -index * 1258);
    for (var j = 0; j < ol.children.length; j++) {
      if (ol.children[j] == this) {
        this.className = 'current';
      } else {
        ol.children[j].className = '';
      }
    }
  }
}

$(function () {
  $(".topnav>ul>li:eq(0)").siblings().mouseenter(function () {
    $(this)[0].className = "current";
    $(this).children("div").show();
  })
  $(".topnav>ul>li:eq(0)").siblings().mouseleave(function () {
    $(this).children("div").hide();
    $(this)[0].className = ""
  })
  $(".tools .lang").mouseenter(function () {
    $(this).children("div").show();
  })
  $(".tools .lang").mouseleave(function () {
    $(this).children("div").hide();
  })
  $(".tools .login").mouseenter(function () {
    $(this).children("div").show();
  })
  $(".tools .login").mouseleave(function () {
    $(this).children("div").hide();
  })
  $(".tools .scbtn").click(function () {
    $(this).children("div").show();
  })
  $("#search input").blur(function () {
    var search = $("#search")[0];
    setTimeout(function () {
      search.style.display = "none";
    }, 2000);
  })

  //ͻ����ʾ
  $('.chenlie_pic_ul li').mouseenter(function () {
    $(this).css('opacity', 1).siblings('li').css('opacity', 0.8);
  })

  $('.chenlie_pic').mouseleave(function () {
    $(this).find('li').css('opacity', 1);
  });

  //��ʾ��ά��
  //�����:��ͼƬһֱ����˸
  $('.nav_foot_tag1').on('mouseenter', function () {
    $('.nav_foot_tag3').show();
  })
  $('.nav_foot_tag1').on('mouseleave', function () {
    $('.nav_foot_tag3').hide();
  })

});





