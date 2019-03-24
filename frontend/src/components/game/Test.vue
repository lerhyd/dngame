<template>
  <div id="main-div">
    <Header></Header>
    <UserData></UserData>
      <div id="news-area" v-bind:style="styleObject" >
        <!--<div v-for="news in this.$store.getters.news">-->
        <div>
          <p><b>Свежайшие новости!</b></p>
          <a>Дата публикации: 21.11.1200:00.00.00</a>
          <br><br>
          <a>Заголовок: FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF</a>
          <br><br>
          <a>Что случилось: мужчина Имя Фамилия Отччество убил гггггггггггггггг
          </a><br><br>
          <a>Предполагаемый виновный:
            мужчина Имя Фамилия Отччество гггггггггггггггг
          </a><br><br>
          <a>Место происшествия: ггггггггггггггггггггггг</a>
        </div>
      </div>

    <section>
      <button class="menu-buttons"><a>Перезайти</a></button>
      <button class="menu-buttons"><a>Перезайти</a></button>
      <button class="menu-buttons"><a>Перезайти</a></button>
      <button class="menu-buttons"><a>Перезайти</a></button>
      <button class="menu-buttons"><a>Перезайти</a></button>
      <button class="menu-buttons"><a>Перезайти</a></button>

    </section>


      <div id="notebook-paper">
        <!--<h1>Fancy Title</h1>-->
        <div id="content">
          <div class="hipsum">
            <p>Адриан Ильич Шашков мужчина<br>
            Описание смерти: 1<br>
            Причина смерти: был(-а) зарезан(-а)<br>
            Место смерти: на восточном рынке<br>
            Время смерти: 2019-03-31T13:22<br>

            </p>
            <p>Intelligentsia lo-fi pug Austin.  Shabby chic asymmetrical jean shorts, twee stumptown</p>
            <p>Intelligentsia lo-fi pug Austin.  Shabby chic asymmetrical jean shorts, twee stumptown</p>
          </div>
        </div>
      </div>



    <!--<footer id="game-footer">-->
      <!--refd-->

    <!--</footer>-->
  </div>
</template>

<script>
  import Header from "@/components/main/Header";
  import UserData from "@/components/game/UserData";
  export default {
    components: {UserData, Header},
    name: "Test",
    data() {
      return {
        styleObject: {
          position: 'absolute',
          height: window.innerHeight*0.42+'px',
          width: window.innerWidth*0.36+'px',
          top: window.innerHeight*0.16+'px',
          left: window.innerWidth*0.207+'px',
          // border: 'red 2px solid'
        },
      }
    }



  }
</script>

<style>

  .menu-buttons{
    height: 40px;
    display: inline;
    width: 160px;
    margin-top: 15px;
    cursor: pointer;
    font-family: 'Hand';
    font-size: large;
    color: #111111;
    border-radius: 6px;
    border: 1px solid #fdfefd;
    user-focus: none;
    background: whitesmoke;
    outline: none;
  }

  .menu-buttons a{
    text-decoration: none;
    color: #111111;
  }

  .menu-buttons:hover a {
    font-size: 17px;
    mix-blend-mode: multiply;
  }

  #news-area{
    font-family: 'Arial';
    padding-left: 6px;
  }


  #notebook-paper {
    -webkit-box-sizing:border-box;
    -moz-box-sizing:border-box;
    -ms-box-sizing:border-box;
    -o-box-sizing:border-box;
    box-sizing:border-box;
    background: #f1f1f1;
    font-family:helvetica neue, helvetica, arial, sans-serif;
    font-weight:200;
    width:95%;
    height:500px;
    background: linear-gradient(to bottom,white 29px,#00b0d7 1px);
    margin:0px auto;
    background-size: 100% 30px;
    position:relative;
    padding-left:8%;
    padding-right:20px;
    overflow-y: scroll;
    border-radius:5px;
    -webkit-box-shadow:3px 3px 3px rgba(0,0,0,.2),0px 0px 6px rgba(0,0,0,.2);
    -moz-box-shadow:3px 3px 3px rgba(0,0,0,.2),0px 0px 6px rgba(0,0,0,.2);
    -ms-box-shadow:3px 3px 3px rgba(0,0,0,.2),0px 0px 6px rgba(0,0,0,.2);
    -o-box-shadow:3px 3px 3px rgba(0,0,0,.2),0px 0px 6px rgba(0,0,0,.2);
    box-shadow:3px 3px 3px rgba(0,0,0,.2),0px 0px 6px rgba(0,0,0,.2);}

  #notebook-paper:before {
     content:'';
     display:block;
     position:absolute;
     z-index:1;
     top:0;
     left:7%;
     height:100%;
     width:1px;
     background:#db4034;
   }

  #content {
    margin-top:5px;
    font-size:20px;
    line-height:30px;}

  #content p {
    margin:0 0 30px 0;
  }

  #game-footer{
    border: 1px red solid;
    display: inline-block;
    position: absolute;
    margin-bottom: 5px;
    /*padding-bottom: 5px;*/
  }

  #main-div{
    -webkit-touch-callout: none; /* iOS Safari */
    -webkit-user-select: none;   /* Chrome/Safari/Opera */
    -khtml-user-select: none;    /* Konqueror */
    -moz-user-select: none;      /* Firefox */
    -ms-user-select: none;       /* Internet Explorer/Edge */
    user-select: none;
  }

  html{
    background-image: url(../../assets/img/computer3.png);
    background-size: 100%;
    background-repeat: no-repeat;
       /*background-color: #585858;*/
     }

  section {
    float: left;
    margin: 0 1%;
    width: 15%;
    border: 1px solid blue;

  }
  aside {
    float: right;
    /*margin: 0 1%;*/
    width: 80%;
    border: 1px solid red;

  }


</style>
