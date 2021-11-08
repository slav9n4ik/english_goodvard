const menuButton = document.querySelector('.open-nav');
const nav = document.querySelector('.nav');

menuButton.addEventListener("click", () => {
    if (nav.classList.contains('navigation-open')) {
        nav.classList.remove('navigation-open');
    } else {
        nav.classList.add('navigation-open');
    }
});

// Courses
if (window.screen.width <= 700) {
  var swiper = new Swiper('.course-swiper-container', {
    pagination: {
      el: '.course-swiper-pagination',
      type: 'bullets',
    },
    navigation: {
      nextEl: '.course-swiper-button-next',
      prevEl: '.course-swiper-button-prev',
    }
  });
} else {
  let swiperWrapper = $(".course-swiper-wrapper")[0];
  swiperWrapper.className = swiperWrapper.className.replace("swiper-wrapper", "swiper-wrapper-desktop");
  let activeMainContents = $(".course-item-active");
  let swiperSlides = $(".course-swiper-slide");
  let coursesRow = $(".courses-row");
  $(".course-item-active").detach();
  $(".course-swiper-slide").detach();
  $(".courses-row").detach();

  //TODO dummy hardcode
  swiperWrapper.append(coursesRow[0]);
  swiperWrapper.append(activeMainContents[0]);
  swiperWrapper.append(activeMainContents[1]);
  swiperWrapper.append(coursesRow[1]);
  swiperWrapper.append(activeMainContents[2]);
  swiperWrapper.append(activeMainContents[3]);


  coursesRow[0].append(swiperSlides[0]);
  coursesRow[0].append(swiperSlides[1]);
  coursesRow[1].append(swiperSlides[2]);
  coursesRow[1].append(swiperSlides[3]);

}

var arrows = $(".more-course-info-btn");
var activeItems = $(".course-item-active");
var items = $(".course-item");
var activeImages = $(".active-img");
var offsetHeightItem = items[0].offsetHeight;

// Course desktop more info
function showMoreInfo(itemIndex) {
  if (window.screen.width > 700) {
    for (let i = 0; i < items.length; i++) {
      if (i === itemIndex) {
          items[i].className.includes("course-active") ? 
            closeCourseBlock(i, offsetHeightItem) : showCourseBlock(i, offsetHeightItem)
      } else {
        closeCourseBlock(i, offsetHeightItem);
      } 
    }
  }
 }

function showCourseBlock(i, offsetHeight) {
    items[i].className += " course-active";
    items[i].style.height = offsetHeight * 1.15 + 'px';
    activeItems[i].style.display = 'flex';
    activeImages[i].style.display = 'flex';
    activeItems[i].style.marginTop = offsetHeight * -0.1  + 'px';
    arrows[i].style.display = 'none';
 }

function closeCourseBlock(i, offsetHeight) {
    items[i].className = items[i].className.replace(" course-active", "");
    items[i].style.height = offsetHeight + "px";
    activeItems[i].style.display = 'none';
    activeImages[i].style.display = 'none';
    arrows[i].style.display = 'block';
}


//video-course
var swiperVideoCourse = new Swiper('.video-course-swiper-container', {
  navigation: {
    nextEl: '.video-course-swiper-button-next',
    prevEl: '.video-course-swiper-button-prev'
  },
  breakpoints: {
    760: {
      slidesPerView: 2,
      spaceBetween: 4
    }
  }
});

function showMoreCourseInfoOnSlide(block) {
  if (block === 1) {
    showMoreCourseInfo(1);
    showMoreCourseInfo(2);
  } else {
    showMoreCourseInfo(3);
    showMoreCourseInfo(4);
  }
}

function showMoreCourseInfo(item) {
  var videoCourseContent = $(".video-course-content-" + item)[0];
  if (videoCourseContent.style.maxHeight === null ||  
  videoCourseContent.style.maxHeight === '') {  
    videoCourseContent.style.maxHeight = videoCourseContent.scrollHeight + "px";
  } else {
    closeMoreCourseInfo(item);
  }
}

function closeMoreCourseInfo(item) {
  let content = $(".video-course-content-" + item)[0];
  content.style.maxHeight = null;
}

function closeAllCourseInfo(block) {
  showMoreCourseInfoOnSlide(block)
}


//video section
var galleryThumbs = new Swiper('.video-gallery-thumbs', {
  spaceBetween: 15,
  slidesPerView: 3,
  freeMode: true,
  watchSlidesVisibility: true,
  watchSlidesProgress: true,
  pagination: {
    el: '.video-swiper-pagination',
    type: 'bullets',
  },
  navigation: {
    nextEl: '.video-swiper-button-next',
    prevEl: '.video-swiper-button-prev',
  },
  breakpoints: {
    760: {
      slidesPerView: 3,
      direction: 'vertical',
    }
  }
});

var galleryTop = new Swiper('.video-gallery-top', {
  spaceBetween: 10,
  slidesPerView: 1,
  thumbs: {
    swiper: galleryThumbs
  }
});

$('.video').parent().click(function () {
  if($(this).children(".video").get(0).paused){
      $(this).children(".video").get(0).play();
      $(this).children(".video").attr("controls", "controls");
      $(this).children(".playpause").fadeOut();
  }else{
     $(this).children(".video").get(0).pause();
     $(this).children(".video").removeAttr("controls");
      $(this).children(".playpause").fadeIn();
  }
});

//gallery
var gallerySwiper = new Swiper(".gallery-container", {
  effect: "coverflow",
  grabCursor: true,
  centeredSlides: true,
  slidesPerView: 2,
  loop: true,
  coverflowEffect: {
    rotate: 70,
    stretch: 10,
    depth: 100,
    modifier: 1,
    slideShadows: false,
  },
  breakpoints: {
    760: {
      spaceBetween: 5
    }
  },
  navigation: {
    nextEl: '.gallery-swiper-button-next',
    prevEl: '.gallery-swiper-button-prev',
  },
});

//team
var swiperTeam = new Swiper('.team-container', {
  breakpoints: {
    750: {
      spaceBetween: 1,
      slidesPerView: 2
    },
    1200: {
      spaceBetween: 20,
      slidesPerView: 3
    }
  },
  navigation: {
    nextEl: '.team-swiper-button-next',
    prevEl: '.team-swiper-button-prev'
  }
});

var coll = $(".team-more-btn");
for (let i = 0; i < coll.length; i++) {
  coll[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var content = $(".team-more-information")[i];
    if (content.style.display === "block") {
      content.style.display = "none";
    } else {
      content.style.display = "block";
    }
  });
}

swiperTeam.on('slideChange', function () {
  for (let i = 0; i < coll.length; i++) {
    var content = $(".team-more-information")[i];
    content.style.display = "none";
  }
});

//comments
var commentGalleryThumbs = new Swiper('.comments-gallery-top', {
  slidesPerView: 1,
  navigation: {
    nextEl: '.comment-swiper-button-next',
    prevEl: '.comment-swiper-button-prev',
  },
});

var commentMoreBtn = $(".comment-more-btn");
for (let i = 0; i < commentMoreBtn.length; i++) {
  commentMoreBtn[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var content = $(".comment-more-info")[i];
    if (content.style.display === "block") {
      content.style.display = "none";
    } else {
      content.style.display = "block";
    }
  });
}

commentGalleryThumbs.on('slideChange', function () {
  for (let i = 0; i < coll.length; i++) {
    var content = $(".comment-more-info")[i];
    content.style.display = "none";
  }
});

//form
function displaySubmitByCheckBoxValue() {
  if ($('.rights-checkbox').is(':checked')){
    $('#btn-form')[0].style.display = 'block';
  } else {
    $('#btn-form')[0].style.display = 'none';
  }
}

displaySubmitByCheckBoxValue()

var userDefaultFormInfo = {
  status: 'INTERESTED',
}

function setUserStatus(status) {
  userDefaultFormInfo.status = status;
  if (status === 'INTERESTED_VIDEO') {
    let msg = "Добрый день! Хотим узнать про видео-курсы. Свяжитесь с нами, пожалуйста!"
    $("#message").val(msg)
  }
}

$("#contact-form").submit(function(e){
  e.preventDefault();
  var formData = {
    name: $("#fname").val(),
    email: $("#email").val(),
    phone: $("#phone").val(),
    message: $("#message").val(),
    status: userDefaultFormInfo.status
  };

  let host = window.location.host;
  if (host.includes("localhost")) {
    host = "http://localhost:8080"
  } else {
    host = "https://" + host;
  }

  $.ajax({
    url: host + "/api/send",
    type: 'post',
    headers: { 
      'Accept': 'application/json',
      'Content-Type': 'application/json' 
    },
    contentType:"application/json; charset=utf-8",
    dataType:"json",
    data: JSON.stringify({data: formData}),
    success: function() {
      $.growl.notice({ message: "Сообщение успешно доставлено!!" });
    },
    error: function() {
      $.growl.error({ message: "Ошибка при отправке сообщения!" });
    }
  })
});

//map
ymaps.ready(function () {
  var map = new ymaps.Map("YMapsID", {
    center: [55.60105316368484, 38.086919431213325],
    zoom: 16,
    controls: ["zoomControl"]
  });

  if (map) {
    ymaps.modules.require(['Placemark', 'Circle'], function (Placemark, Circle) {
      var placemark = new Placemark([55.60105316368484, 38.086919431213325]);
      map.geoObjects.add(placemark);
    });
  }

  let mapStyle = $("#YMapsID")[0].style;
  if (window.screen.width > 700) {
    mapStyle.minWidth = '400px'
    $('#map-wrapper')[0].style.minWidth = '400px'
  }
  if (window.screen.width > 1025) {
    mapStyle.minWidth = '600px'
    $('#map-wrapper')[0].style.minWidth = '600px'
  }

  map.container.fitToViewport();
});



