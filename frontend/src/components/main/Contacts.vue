<template>
  <div>
    <Header></Header>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <section class="left-section">
      <a>CO8ECTb</a>
      <img src="../../assets/img/k13.png"/>
    </section>
    <section class="main-section">
      <div class="wrapper">
        <div class="questions-list">
        <ul>
          <li><a>Есть предложения по улучшению?</a></li>
          <li><a>Не можешь войти в свой аккаунт или восстановить его?</a></li>
          <li><a>Возникли проблемы во время игрового процесса?</a></li>
          <li><a>Или нашел очередной баг? (возможно это фича)</a></li>
          <li><a>А может появились какие-то вопросы?</a></li>
        </ul>
        </div>
        <br>
        <a>Тогда пиши на нашу почту с соответствующей темой письма. Мы постараемся ответить в ближайшее время (наберитесь терпения)<br>
          <a href="mailto:deathNoteProject@yandex.ru">deathNoteProject@yandex.ru</a></a>
        <a>Ну а если ты считаешь, что разработчики козлы, уроды и вообще у них руки растут не из того места, то можешь им об этом написать</a>
        <div class="contacts-table">
          <table>
            <td width="50%" align="center" id="first-row">
              <tr>CO8ECTb</tr>
              <tr>
                <div class="button telegram">
                  <i class="fa fa-telegram" aria-hidden="true" ></i>
                  <div class="slide">
                    <a href="http://t.me/c08ectb">Telegram</a>
                  </div>
                </div>
                <div class="button github">
                  <i class="fa fa-github" aria-hidden="true" ></i>
                  <div class="slide">
                    <a href="https://github.com/CO8ECTb">GitHub</a>
                  </div>
                </div>
              </tr>
            </td>
            <td width="50%" align="center">
              <tr>Pizza-Eater</tr>
              <tr>
                <div class="button telegram">
                  <i class="fa fa-telegram" aria-hidden="true" ></i>
                  <div class="slide">
                    <a href="http://t.me/kuroiavem">Telegram</a>
                  </div>
                </div>
                <div class="button github">
                  <i class="fa fa-github" aria-hidden="true" ></i>
                  <div class="slide">
                    <a href="https://github.com/lerhyd">GitHub</a>
                  </div>
                </div>
              </tr>
            </td>
          </table>
        </div>
      </div>
    </section>
    <section class="right-section">
      <a>Pizza-Eater</a>
      <img src="../../assets/img/l13.png"/>
    </section>
  </div>
</template>

<script>
    import Header from "@/components/main/Header";
    export default {
        name: "Contacts",
      components: {Header}
    }
</script>

<style scoped>

  .contacts-table{
    margin-top: 10px;
    margin-bottom: 10px;
    color: #111111;
    font-size: x-large;
    width: 85%;
    position: center;
    display: inline-block;
    padding: 0 10px;

  }

  .contacts-table table {
    position: center;
    align-content: center;
    alignment: center;
    width: 100%;
    text-align: center;
    align: center;
  }

  #first-row{
    padding-top: 30px;
    /*border-right: 1px solid #111111;*/
    border-width: 1px;
    border-style: solid;
    border-image:
      linear-gradient(
        to bottom,
        #585858,
        rgba(255, 255, 255, 0)
      ) 1 100%;
    border-left: transparent;
  }


  .questions-list {
    background: white;
    width: 75%;
    align-content: center;
    position: center;
    display: inline-block;
    padding: 0 10px;
    margin: 0;
  }
  .questions-list li {
    border-bottom: 1px solid #efefef;
    padding: 10px 0;
    list-style-type: circle;
    list-style-position: inside;
  }
  .questions-list a {
    text-decoration: none;
    color: #5e5e5e;
    font-family: 'Hand';
    font-size: 20px;
  }

  .telegram {
    background: #2EA3DD;
  }

  ul{
    color: #111111;
    /*border: blue 1px solid;*/
    text-align: left;
  }

  a{
    color: #5e5e5e;
    font-size: 21px;
  }
  a a{
    color: #111111;
    text-align: center;
    display: block;
    font-size: x-large;
    margin-top: 15px;
    margin-bottom: 15px;
  }

  .github {
    background: #24282D;
  }

  .wrapper{
    display: inline-block;
    position: center;
    height: 90%;
    width: 80%;
    /*border: 5px solid;*/
    background: white;
    /*border-image: linear-gradient(90deg, #d6d6d6 0%, #1e1e1e 100%);*/
    /*border-image-slice: 1;*/
    font-family: 'Hand';
    box-shadow: 0px 0px 60px 50px #ffffff;
  }

  .button {
    position: relative;
    display: block;
    float: left;
    height: 40px;
    margin: 4px;
    overflow: hidden;
    width: 130px;
    border-radius: 3px;
    cursor: pointer;
  }

  .fa {
    display: block;
    float: left;
    position: relative;
    height: 100%;
    width: 38px;
    color: #fff;
    line-height: 42px;
    font-size: x-large;
    /*background: white;*/
  }


  .slide {
    z-index: 2;
    display: block;
    margin: 0;
    height: 100%;
    left: 38px;
    position: absolute;
    width: 90px;
  }

  .slide a {
    font-family: "Apple Symbols";
    border-left: 1px solid rgba(255,255,255,0.35);
    color: #fff;
    font-size: 20px;
    left: 0;
    margin: 0;
    position: absolute;
    text-align: center;
    top: 10px;
    width: 100%;
    text-decoration: none;
  }


  .left-section{
    float: left;
    display: inline-block;
    width: 25%;
    text-align: center;
    margin-top: 1%;
    margin-bottom: 1%;

  }

  .left-section a{
    font-family: 'DeathNote';
    font-size: 40px;
    color: white;
  }

  .right-section a{
    font-family: 'DeathNote';
    font-size: 40px;
    color: white;
  }

  .right-section{
    float: right;
    display: inline-block;
    width: 25%;
    text-align: center;
    margin-top: 1%;
    margin-bottom: 1%;
  }

  section img{
    height: auto;
    width: 100%;
    /*border: red 1px solid;*/
    /*margin-top: 0px;*/
  }

  .main-section{
    width: 45%;
    text-align: center;
    position: absolute;
    top: 50%;
    left: 50%;
    -moz-transform: translateX(-50%) translateY(-50%);
    -webkit-transform: translateX(-50%) translateY(-50%);
    transform: translateX(-50%) translateY(-50%);
  }

  @media screen and (max-width: 700px){

    .wrapper{
      width: 95%;
      box-shadow: none;
      border-radius: 20px;
    }

    a{
      color: #5e5e5e;
      font-size: 15px;
    }
    a a{
      color: #111111;
      text-align: center;
      display: block;
      font-size: large;
      margin-top: 10px;
      margin-bottom: 10px;
    }
    .questions-list {
      width: 80%;
      background: transparent;
    }

    .questions-list a {
      text-decoration: none;
      color: #5e5e5e;
      font-family: 'Hand';
      font-size: small;
    }

    #first-row{padding-top: 10px;}

    .left-section{display: none;}

    .right-section{display: none;}

    .main-section{width: 95%;}
  }

  @media screen and (min-width:701px) and (max-width: 1209px){
    .left-section{display: none;}

    .right-section{display: none;}

    .main-section{width: 95%;}
  }

</style>
