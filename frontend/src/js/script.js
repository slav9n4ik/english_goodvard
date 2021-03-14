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

// mobile course slider
function showSlides(n) {
  if (window.screen.width <= 700) {
    let containers = document.getElementsByClassName("courses-container");
    let slides = document.getElementsByClassName("course-item");
    let activeSlides = document.getElementsByClassName("course-item-active");
    let dots = document.getElementsByClassName("dot");

    if (n > slides.length) {slideIndex = 1}
    if (n < 1) {slideIndex = slides.length}

    if (slideIndex === 1 || slideIndex === 2) {
      containers[0].style.display = "flex";
      containers[1].style.display = "none";
    } else {
      containers[1].style.display = "flex";
      containers[0].style.display = "none";
    }

    for (let i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
        activeSlides[i].style.display = "none";
    }
    for (let i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }
    slides[slideIndex-1].style.display = "flex";
    activeSlides[slideIndex-1].style.display = "flex";
    dots[slideIndex-1].className += " active";
  } 
}

// Course desktop more info
function showMoreInfo(itemIndex) {
  let activeItems = document.getElementsByClassName("course-item-active");
  let items = document.getElementsByClassName("course-item");
  let isActive = false;

  for (i = 0; i < items.length; i++) {
    if (i != itemIndex) {
      items[i].style.maxHeight = '250px';
    } else {
      items[i].style.maxHeight = 'none';
    }
    if (items[i].className.includes('active')) {
      isActive = true;
    }
  }

  if (items[itemIndex].className.includes('active') ) {
    items[itemIndex].className = items[itemIndex].className.replace(" active", "");
    items[itemIndex].style.borderRadius = '45px';
    items[itemIndex].style.height = 'none';
    items[itemIndex].style.backgroundColor = 'rgb(255, 255, 255, 0.8)';
  } else {
    if (!isActive) {
      items[itemIndex].className += " active";
      items[itemIndex].style.height = '260px';
      items[itemIndex].style.borderRadius = '45px 45px 0 0';
      items[itemIndex].style.backgroundColor = 'rgb(255, 255, 255, 1)';
    }
  }

  let display = activeItems[itemIndex].style.display;
  if (display === 'none' || display === undefined || display === '') {
    if (!isActive) {
      activeItems[itemIndex].style.display = 'flex';
    }
  } else {
    activeItems[itemIndex].style.display = 'none';
  }
 }