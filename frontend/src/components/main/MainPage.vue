<template>
  <div>
    <Header></Header>
    <section class="main-page-section">
      <div class="main-wrapper">
      <!--To use it you have to install library using command 'npm install sass-loader node-sass --save-dev'-->
      <!--And this one 'npm install vue-agile'-->
          <agile :infinite="false" :dots="false" :arrows="false" :autoplay="true" :speed="1700"
          :timing="'linear'" :fade="true" :pauseOnHover="false" :autoplaySpeed="6500">
            <div class="slide slide--1">
              <div class="text-on-slide"><h3>Добро пожаловать в онлайн головоломку по известной манге Death Note (Тетрадь смерти),
                а также выпущенных на её основе анимационные сериал и фильмы. Выбери свою сторону.
              </h3></div>
            </div>
            <div class="slide slide--2">
              <div class="text-on-slide"><h3>В Death Note game представлено два типа персонажей на выбор. Играй за гениального агнета L
                или за безумного убийцу Киру. Победи соперника и открывай ачивки.
              </h3></div>
            </div>
            <div class="slide slide--3">
              <div class="text-on-slide"><h3>Играя за агента L определи местоположение своего противника и застань его врасплох.
                Учи страны вместе с нами и порази учительницу географии своими знаниями. Теперь ты
                действительно учишься играя в компунктер.
              </h3></div>
            </div>
            <div class="slide slide--4">
              <div class="text-on-slide"><h3>Генерируй новости криминального мира, лови Киру на ошибках и веди себя к
                 победе в сражении. Делай невероятные серии побед и докажи всем, что ты лучший детектив.
              </h3></div>
            </div>
            <div class="slide slide--5">
              <div class="text-on-slide"><h3>Играя за Киру ты сможешь проявить всю свою фантазию, убивая преступников.
                Опиши все обстоятельства смерти так, чтобы никто и никогда не смог тебя заподозрить.
              </h3></div>
            </div>
            <div class="slide slide--6">
              <div class="text-on-slide"><h3>Выбери удобный для тебя регион и обыграй соперника за наименьшее число ходов.
                Победи всех агентов и докажи, что мир, который ты создаешь, становится все совершеннее
                и совершеннее.
              </h3></div>
            </div>
          </agile>
          <img src="../../assets/img/swipe.png" style="width: 5%; margin-top: 3px;"/>
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

  .main-page-section{
    width: 100%;
    text-align: center;
    position: absolute;
    top: 50%;
    /*border: 1px red solid;*/
    left: 50%;
    -moz-transform: translateX(-50%) translateY(-50%);
    -webkit-transform: translateX(-50%) translateY(-50%);
    transform: translateX(-50%) translateY(-45%);
    font-family: 'Hand';
  }

  .main-wrapper {
    width: 95%;
    /*border: solid 1px blue;*/
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

    .text-on-slide{
      position: absolute;
      width: 35%;
      background: #dddddd;
      color: #111111;
      border-radius: 5px;
    }

    .text-on-slide h3 {
      font-size: x-large;
      text-align: center;
      padding-left: 5px;
      padding-right: 5px;
    }

    &--1{
      background-image: url(../../assets/img/slide1.jpg);
      div {top: 5%; left: 2%;}

    }

    &--2{
      background-image: url(../../assets/img/slide2.jpg);
      div{bottom: 5%; left: 2%;}
    }

    &--3{
      background-image: url(../../assets/img/slide3.jpg);
      div{bottom: 5%; right: 2%;}
      h3{font-size: 22px}
    }

    &--4{
      background-image: url(../../assets/img/slide4.png);
      div{bottom: 5%; left: 2%;}

    }

    &--5 {
      background-image: url(../../assets/img/slide5.png);
      div{top: 5%; left: 2%;}
    }

    &--6 {
      background-image: url(../../assets/img/slide6.jpg);
      div{top: 5%; left: 2%;}
      h3{font-size: 22px}
    }
  }



  @media screen and (max-width: 700px){

    .slide {

      .text-on-slide{
        position: absolute;
        width: 95%;
        background: #dddddd;
        color: #111111;
        border-radius: 3px;
      }

      .text-on-slide h3 {
        font-size: large;
        text-align: center;
        padding-left: 2px;
        padding-right: 2px;
      }

      &--1 {
        background-image: url(../../assets/img/mobSlide1.jpg);
        div{bottom: 1%; top: auto}

      }

      &--2 {
        background-image: url(../../assets/img/mobSlide2.jpg);
        div{width: 30%}
      }

      &--3 {
        background-image: url(../../assets/img/mobSlide3.jpg);
        div{right: 0%; top: 1%; bottom: auto}
        h3{font-size: 18px}
      }

      &--4 {
        background-image: url(../../assets/img/mobSlide4.jpg);
      }

      &--5 {
        background-image: url(../../assets/img/mobSlide5.png);
        div{bottom: 1%; left: revert; right: revert; top: auto}
      }

      &--6{
        div{top: 1%; left: revert; right: revert}

      }
    }

  }
</style>
