const menuButton = document.querySelector('.open-nav');
const nav = document.querySelector('.nav');

menuButton.addEventListener("click", () => {
    if (nav.classList.contains('navigation-open')) {
        nav.classList.remove('navigation-open');
    } else {
        nav.classList.add('navigation-open');
    }
});


/* Course Carousel */
var slideIndex = 1;
showSlides(slideIndex);

// Next/previous controls
function plusSlides(n) {
  showSlides(slideIndex += n);
}

// Thumbnail image controls
function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
  if (window.screen.width <= 700) {
    var i;
    var slides = document.getElementsByClassName("course-item");
    var dots = document.getElementsByClassName("dot");
    if (n > slides.length) {slideIndex = 1}
    if (n < 1) {slideIndex = slides.length}

    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }
    slides[slideIndex-1].style.display = "flex";
    dots[slideIndex-1].className += " active";
  } 
}


// Course more info
function showMoreInfo(n) {
  let activeItems = document.getElementsByClassName("course-item-active");
  let display = activeItems[n-1].style.display;
  if (display === 'none' || display === undefined || display === '') {
    activeItems[n-1].style.display = 'block';
  } else {
    activeItems[n-1].style.display = 'none';
  }

  let items = document.getElementsByClassName("course-item");
  for (i = 0; i < items.length; i++) {
    if (i != (n - 1)) {
      console.log(items[i])
      items[i].style.maxHeight = '250px';
    } else {
      items[i].style.maxHeight = 'none';
    }
  }
 }