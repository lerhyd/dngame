<template>
    <div id="app">
      <Header></Header>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
      <section class="left-section-about">
        <div class="main">
          <agile :infinite="false" :dots="false" :arrows="false" :autoplay="true" :speed="1700"
                 :timing="'linear'" :fade="true" :pauseOnHover="false" :autoplaySpeed="4500">
            <div class="slides slides--1"></div>
            <div class="slides slides--2"></div>
            <div class="slides slides--3"></div>
          </agile>
        </div>
      </section>
      <section class="main-section-about">
        <div class="main-table-area">
          <table>
            <td id="first-table-row">
              <tr><button class="button-state" v-on:click="state = 3">Что это вообще такое?</button></tr>
              <tr><button class="button-state" v-on:click="state = 1">Правила игры</button></tr>
              <tr><button class="button-state" v-on:click="state = 2">Правила Тетради</button></tr>
              <tr><button class="button-state" v-on:click="state = 5">А зачем?</button></tr>
              <tr><router-link to="/contacts"><button class="button-state" >Ещё вопросы?</button></router-link></tr>
            </td>
            <td id="second-table-row">
              <tr colspan="5" id="content-area">
                <a v-if="state == 0">Выбери раздел. Рискни, открой ящик пандоры
                  и узнай тайны, хранящиеся за семью печатями!</a>
                <a v-if="state == 1">
                  <h3>После выбора персонажа начинается игра</h3>
                  <ol>
                    <li>Убийца и агент получают 30 очков. Их уровень и количество убитых/пойманных преступников равно 0, их ранг выставлен, как самый низкий</li><br>
                    <li>Для победы в качестве убийцы надо:</li>
                    <ul>
                      <li>заработать 300 или больше очков,</li>
                      <li>дождаться, пока противник потратит все баллы</li>
                    </ul>
                    <br>
                    <li>Для поражения в качестве убийцы надо:</li>
                    <ul>
                      <li>потратить все баллы,</li>
                      <li>быть пойманным противником;</li>
                    </ul>
                    <br>
                    <li>Для победы в качестве агента надо:</li>
                    <ul>
                      <li>заработает 300 или больше очков,</li>
                      <li>дождаться, пока противник потратит все баллы,</li>
                      <li>поймать противника;</li>
                    </ul><br>
                    <li>Для поражения в качестве агента надо:</li>
                    <ul><li>потратить все баллы;</li></ul><br>
                    <li>После начала матча задача игрок видит новости. На них основан весь геймплей.</li><br>
                    <li>Главная задача после начала матча для убийцы:</li>
                    <ul>
                      <li>Внимательно следить за новостями и, исходя из собственных соображений, записывать преступников в тетрадь смерти,</li>
                      <li>Избегать фальшивых новостей агента;</li>
                    </ul><br>
                    <li>Главная задача после начала матча для агента:</li>
                    <ul>
                      <li>Внимательно следить за новостями и, исходя из собственных соображений, вычислять преступника и отправлять отчёт в полицию,</li>
                      <li>Пытаться поймать убийцу посредством распространения фейковых новостей по различным регионам, где может оказаться преступник.</li>
                    </ul><br>
                    <li>В случае, когда победитель не может определиться, а остальные люди погибают или попадают в тюрьму, то никто не побеждает и объявляется ничья.</li>
                  </ol>
                  <h3>Углубляясь в детали геймплея:</h3>
                  <ol>
                    <li>Стоимость создания записи в тетрадь смерти - 5 очков,</li><br>
                    <li>За убийство невиновного штраф - 10 очков,</li><br>
                    <li>За убийство преступника награда - 15 очков,</li><br>
                    <li>Стоимость отправки запроса в полицию - 5 очков,</li><br>
                    <li>За донос на невиновного штраф - 10 очков,</li><br>
                    <li>За донос на виновного награда - 15 очков,</li><br>
                    <li>Стоимость создания фальшивой новости - 40 очков,</li><br>
                    <li>За успешное нахождение региона, в котором находится преступник награда - 50 очков,</li><br>
                    <li>Каждый раз при изменении статистики игрока выставляется соответствующий уровень и ранг. За каждые 3 успешно
                      пойманных/убитых преступника выставляется соответствующий уровень. Всего 30 уровней. Каждый уровень даёт разные
                      виды преступлений и места действия для манипуляции игроками при создании записи, новостей,</li><br>
                    <li>Ранг выставляется в соответствии накопленными очками игроков и отражает их мастерство. Последний ранг соответствует 256 очкам и более.</li><br>
                    <li>Перед поиском матча, игрок нвыбирает регион, в котором будет располагаться его персонаж</li><br>
                  </ol>
                </a>
                <a v-if="state == 2">
                  <ol>
                      <li>Человек, чьё имя будет записано в этой тетради — умрёт.</li><br>
                      <li>Если причина смерти не указана, человек умрёт через 40 секунд от сердечного приступа.</li><br>
                      <li>Тетрадь станет частью человеческого мира в тот момент, когда коснется земли.</li><br>
                      <li>За человеком, получившим тетрадь смерти, до конца жизни будет следовать бог смерти, потерявший эту тетрадь.</li><br>
                      <li>Хозяин тетради сможет видеть и слышать первоначальных владельцев тетради.</li><br>
                      <li>Нельзя убить бога смерти</li><br>
                      <li>Человек, использующий эту тетрадь, не сможет попасть ни в Ад, ни в Рай.</li><br>
                      <li>Бог смерти совершенно не обязан кому-то объяснять, как использовать тетрадь или рассказывать правила, касающиеся человека, владеющего ею.</li><br>
                      <li>Боги Смерти могут увеличивать продолжительность своей жизни, записывая имена людей в тетрадь, но люди не могут.</li><br>
                      <li>Каждый человек имеет латентную склонность к суициду. Если человек напишет в тетрадь свое имя, то он умрет.</li><br>
                      <li>Нельзя убить человека, имя которого записано неверно.</li><br>
                      <li>Если бог смерти решит использовать свою тетрадь, чтобы избавиться от кого, кто угрожает дорогому этому богу человеку, то жизнь последнего будет продлена, но сам бог смерти умрёт.</li><br>
                      <li>Человек, обладающий глазами бога смерти, сможет узнать имя и жизненный срок других, лишь взглянув на них.</li><br>
                      <li>Люди, отказавшиеся от права владения тетрадью смерти, забывают все, ее касающееся.</li><br>
                </ol>
                </a>
                <a v-if="state == 3">
                  <p> Death Note game - это что-то типа игры, в которой ты можешь выбрать сторону.
                    Сразу же после авторизации ты попадешь на страницу выбора персонажа.
                    Ты можешь играть как за Киру, так и за Агента. В зависимости от выбранного
                    персонажа твой gameplay будет отличаться.
                  </p>
                  <p> Главный инструмент <font color="red">Киры</font> - это его тетрадь, в которую он
                    записывает имена людей, которых хочет убить. У <font color="red">Агента</font>
                    же - это планшетный компьютер, с помощью которого он может создавать новости
                    и публиковать их.
                  </p>
                </a>
                <a v-if="state == 5">
                  <p>Хороший вопрос.<br>Когда мы найдем на него ответ, то обязательно сообщим!</p>
                  <p> Ну а если серьезно, то мы просто хотим уже сдать курсач по <font color="red">ПИП</font> и за<font color="red">Б</font>ыть
                    про нег<font color="red">О</font> навсегда!</p>Скорее всего в этот разде<font color="red">Л</font> никто
                  из проверяющих даже не зайдет, поэтому он сделан чисто по фану. Если сюда все же зашел кто-то,
                  то мы, очень удивлены и обрадованы. Всё делалос<font color="red">Ь</font> не зря!
                </a>
              </tr>
            </td>
          </table>
          </div>
      </section>
      <section class="right-section-about">
        <div class="main">
          <agile :infinite="false" :dots="false" :arrows="false" :autoplay="true" :speed="1700"
                 :timing="'linear'" :fade="true" :pauseOnHover="false" :autoplaySpeed="4500">
            <div class="slides slides--4"></div>
            <div class="slides slides--5"></div>
            <div class="slides slides--6"></div>
          </agile>
        </div>
      </section>
    </div>
</template>

<script>
    import Header from "@/components/main/Header";
    export default {
        name: "About",
      components: {Header},
      data (){
        return {
          state: 0
        }
      }
    }
</script>

<style lang="scss" type="text/scss">

  .main {
    width: 99%;
    height: 100%;
    display: inline-block;
    position: center;
  }
  .slides {
    background: {
      position: center;
      size: cover;

    }
    height: 570px;

    &:before {
      background-color: rgba(#000, .2);
      content: '';
      height: 100%;
      left: 0;
      position: absolute;
      top: 0;
      width: 100%;
    }

    div{
      position: absolute;
      width: 35%;
      background: #dddddd;
      color: #111111;
      border-radius: 5px;
    }

    h3 {
      font-size: x-large;
      text-align: center;
      padding-left: 5px;
      padding-right: 5px;
    }

    &--1{
      background-image: url(../../assets/img/mobSlide1.jpg);
      div {top: 5%; left: 2%;}
    }

    &--2{
      background-image: url(../../assets/img/mobSlide4.jpg);
      div{bottom: 5%; left: 2%;}
    }

    &--3{
      background-image: url(../../assets/img/mobSlide3.jpg);
      div{bottom: 5%; right: 2%;}
    }

    &--4{
      background-image: url(../../assets/img/mobSlide5.png);
      div{bottom: 5%; left: 2%;}
    }

    &--5 {
      background-image: url(../../assets/img/mobSlide2.jpg);
      div{top: 5%; left: 2%;}
    }

    &--6 {
      background-image: url(../../assets/img/slide6.jpg);
      div{top: 5%; left: 2%;}
      h3{font-size: 22px}
    }
  }

  .button-state{
    width: 100%;
    height: 70px;
    background: transparent;
    border: transparent;
    outline: none;
    font-family: 'Hand';
    font-size: large;
    letter-spacing: 0;
    text-decoration: none;
    cursor: pointer;
  }

  .button-state:hover,
  .button-state:active {
    letter-spacing: 2px;
    border-bottom: 1px solid #111111;
  }

  .button-state:after,
  .button-state:before {
    transition: all 280ms ease-in-out;
  }

  .button-state:hover:after,
  .button-state:hover:before {
    backface-visibility: hidden;
    border-color: #fff;
    transition: width 350ms ease-in-out;
    width: 70%;
  }

  .button-state:hover:before {
    bottom: auto;
    top: 0;
    width: 70%;
  }

  #content-area{
    text-align: left;
  }

  #first-table-row{
    width: 30%;
  }
  #second-table-row{
    display: block;
    width: 98%;
    margin-left: 1%;
    /*vertical-align: center;*/
    overflow-y: scroll;
    height: 450px;
    border: transparent;

  }

  #app{
    font-family: 'Hand';
  }

  .main-table-area{
    margin-top: 5px;
    margin-bottom: 5px;
    position: center;
    display: inline-block;
    padding: 0 10px;
    width: 95%;
    border: 5px solid rgb(254, 254, 254);
    border-radius: 30px;
    background: rgb(255, 255, 255);
    box-shadow: 0px 0px 10px 10px #ffffff;
  }

  .main-table-area table {
    border-collapse: collapse;
    position: center;
    align-content: center;
    alignment: center;
    width: 100%;
    text-align: center;
    align: center;
    border: 1px #2d2d2d solid;
    border-radius: 10px;
  }

  .main-table-area td {
    border: 1px solid #2d2d2d;
    font-size:large;
  }

  section{
    display: inline-block;
    width: 24%;
    text-align: center;
    color: #111111;
    /*border: 1px gray solid;*/
  }

  section img{width: 100%;}
  .left-section-about{float: left;}

  .right-section-about{float: right;}

  .main-section-about{
    width: 50%;
    text-align: center;
    position: absolute;
    top: 50%;
    left: 50%;
    -moz-transform: translateX(-50%) translateY(-50%);
    -webkit-transform: translateX(-50%) translateY(-50%);
    transform: translateX(-50%) translateY(-50%);
  }

  @media screen and (max-width: 700px){

    .main-table-area{
      width: 95%;
      box-shadow: none;
      border-radius: 20px;
    }

    .left-section-about{display: none;}

    .right-section-about{display: none;}

    .main-section-about{width: 95%;}
  }

  @media screen and (min-width:701px) and (max-width: 1209px){
    .left-section-about{display: none;}

    .right-section-about{display: none;}

    .main-section-about{width: 95%;}

    .main-table-area{width: 80%;}

  }

</style>
