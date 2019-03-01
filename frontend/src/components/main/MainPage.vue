<template>
  <div>
    <Header></Header>
    <!--To use it you have to install library using command 'npm install sass-loader node-sass --save-dev'-->
    <!--And this one 'npm install vue-agile'-->
    <main>
    <!--<agile>-->
      <!--<div class="slide slide&#45;&#45;1"><h3>slide 1</h3></div>-->
      <!--<div class="slide slide&#45;&#45;2"><h3>slide 2</h3></div>-->
      <!--<div class="slide slide&#45;&#45;3"><h3>slide 3</h3></div>-->
      <!--<div class="slide slide&#45;&#45;4"><h3>slide 4</h3></div>-->
      <!--<div class="slide slide&#45;&#45;5"><h3>slide 5</h3></div>-->
      <!--<div class="slide slide&#45;&#45;6"><h3>slide 6</h3></div>-->
    <!--</agile>-->
    <!--<agile :prevArrow="left" :nextArrow="right" :speed="750"-->
           <!--:timing="'linear'" :fade="true"-->
           <!--:autoplay="true" :pauseOnHover="false" :dots="false">-->
      <!--<div class="slide slide&#45;&#45;1"></div>-->
      <!--<div class="slide slide&#45;&#45;2"></div>-->
      <!--<div class="slide slide&#45;&#45;3"></div>-->
    <!--</agile>-->

      <agile :infinite="false" :dots="false" :arrows="false" :autoplay="true" :speed="1750"
      :timing="'linear'" :fade="true"
      :pauseOnHover="true">
        <div class="slide slide--1"><h3>slide 1</h3></div>
        <div class="slide slide--2"><h3>slide 2</h3></div>
        <div class="slide slide--3"><h3>slide 3</h3></div>
        <div class="slide slide--4"><h3>slide 4</h3></div>
        <div class="slide slide--5"><h3>slide 5</h3></div>
        <div class="slide slide--6"><h3>slide 6</h3></div>
      </agile>
    </main>
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
  .slide {
    background: {
      position: center;
      size: cover;

    }
    height: 550px;
    width: 100px;
    /*height: auto;*/
    /*width: 100%;*/

    &:before {
      background-color: rgba(#000, .2);
      content: '';
      height: 100%;
      left: 0;
      position: absolute;
      top: 0;
      width: 100%;
    }

    &--1 {
      background-image: url(../../assets/img/computer.png);
      /*background: blue;*/
    }

    &--2{
      background: red;
    }

    &--3{
      background: orange;
    }

    &--4{
      background: green;
    }

    &--5{
      background: aqua;
    }

    h3 {
      font-size: 32px;
      font-weight: 300;
      left: 50%;
      margin: 0;
      position: absolute;
      top: 50%;
      transform: translate(-50%, -50%);
    }
  }

</style>
