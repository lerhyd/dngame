<template>
  <div>
    <Header></Header>
    <section class="main-section">
      <div class="main">
      <!--To use it you have to install library using command 'npm install sass-loader node-sass --save-dev'-->
      <!--And this one 'npm install vue-agile'-->
          <agile :infinite="false" :dots="false" :arrows="false" :autoplay="true" :speed="1700"
          :timing="'linear'" :fade="true" :pauseOnHover="false" :autoplaySpeed="5000">
            <div class="slide slide--1"><h3>slide 1</h3></div>
            <div class="slide slide--2"><h3>slide 2</h3></div>
            <div class="slide slide--3"><h3>slide 3</h3></div>
            <div class="slide slide--4"><h3>slide 4</h3></div>
            <div class="slide slide--5"><h3>slide 5</h3></div>
          </agile>
      </div>
    </section>
  </div>
</template>
<script>
    import Header from "@/components/main/Header";
    export default {
        name: "MainPage",
      components: {Header},
    }
</script>

<style lang="scss" type="text/scss">

  .main-section{
    width: 100%;
    text-align: center;
    position: absolute;
    top: 50%;
    left: 50%;
    -moz-transform: translateX(-50%) translateY(-50%);
    -webkit-transform: translateX(-50%) translateY(-50%);
    transform: translateX(-50%) translateY(-45%);
  }

  .main {
    width: 95%;
    height: 100%;
    display: inline-block;
    position: center;
  }
  .slide {
    background: {
      position: center;
      size: cover;

    }
    height: 530px;

    &:before {
      background-color: rgba(#000, .2);
      content: '';
      height: 100%;
      left: 0;
      position: absolute;
      top: 0;
      width: 100%;
    }

    &--5 {
      background-image: url(../../assets/img/slide5.png);
    }

    &--1{
      background-image: url(../../assets/img/slide1.jpg);
    }

    &--2{
      background-image: url(../../assets/img/slide2.jpg);
    }

    &--3{
      background-image: url(../../assets/img/slide3.jpg);
    }

    &--4{
      background-image: url(../../assets/img/slide4.jpg);
    }
/*
    h3 {
      font-size: 32px;
      font-weight: 300;
      left: 50%;
      margin: 0;
      position: absolute;
      top: 50%;
      transform: translate(-50%, -50%);
    }
    */
  }



  @media screen and (max-width: 700px){

    .slide {
      &--1 {
        background-image: url(../../assets/img/mobSlide1.jpg);
      }

      &--2 {
        background-image: url(../../assets/img/mobSlide2.jpg);
      }

      &--3 {
        background-image: url(../../assets/img/mobSlide3.jpg);
      }

      &--4 {
        background-image: url(../../assets/img/mobSlide4.jpg);
      }

      &--5 {
        background-image: url(../../assets/img/mobSlide5.png);
      }
    }

  }


</style>
