<template xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
  <div id="app">
    <header>
      <div class="container">
        <img src="../../assets/img/kira.png" alt="Kira" class="kira">
        <h1>Death Note<br> game</h1>
      </div>
    </header>
    <section class="main">
      <div class="container">
        <div class="info_1">
          <img src="../../assets/img/note.png" alt="Note">
          <p>
            В один прекрасный день ученик старшей школы случайно находит артефакт неизвестного происхождения: Тетрадь Смерти.
            Тот, чьё имя будет записано в этой тетради, умрёт. С помощью неё подросток решил очистить общество от преступников.
            Вскоре таинственные убийства потрясли мир. Никто не знал, почему люди умирают, но все понимали, что
            за этим кто-то стоит. Люди назвали этого человека <b>Кирой</b>(<i>от слова killer</i>).
          </p>
        </div>
        <div class="info_2">
          <p>
            Убийства продолжались, но никто не мог понять, кто за этим стоит. Детектив Л, человек раскрывший самые
            сложные преступления, вызвался поймать загадочного убийцу. Используя свой ум и чутьё <b>Агент</b> Л пытается распутать
            тайны, окутывающие преступника.
          </p>
          <img src="../../assets/img/hand.png" alt="hand">
        </div>
        <div class="info_3">
          <img src="../../assets/img/computer.png" alt="computer">
          <p>
            Многие люди встали на сторону <b>Киры</b>, считая, что преступники действительно заслуживают кары. Другие как <b>Агент</b> посчитали его
            обычным убийцей, которого надо поймать и остановить.
            Выбери сторону и верши своё правосудие.
          </p>
        </div>
      </div>
    </section>
    <section class="login_form">
      <div class="container">
        <Login></Login>
      </div>
    </section>
    <footer>
      <div class="container">
        <router-link to="/contacts">Contacts</router-link>
      </div>
    </footer>
  </div>
</template>

<script>
  import Login from './Login'

  export default {
    name: 'Main',
    components: {Login}
  }
</script>

<style>

  @font-face {
    font-family: 'Alegreya Sans';
    src: local('Alegreya Sans'), local('Alegreya Sans'),
    url('../../assets/fonts/alegreyasans/Alegreyasans.woff2') format('woff2'),
    url('../../assets/fonts/alegreyasans/Alegreyasans.woff') format('woff'),
    url('../../assets/fonts/alegreyasans/Alegreyasans.ttf') format('truetype');
    font-weight: 400;
    font-style: normal;
  }

  #app {
    font-family: 'Alegreya Sans';
    text-align: center;
    color: #EFEFEA;
    background-color: #030000;
    scroll-behavior: smooth;
  }

  .container {
    width: 930px;
    margin: 0 auto;
  }

  div {
    box-sizing: border-box;
  }

  header {
    height: 300px;
  }

  header img {
    float: left;
    height: 300px;
    margin-left: 250px;
  }

  header h1 {
    float: right;
    font-size: 45px;
    font-family: "Droid Sans Mono";
    margin-right: 120px;
    margin-top: 95px;
    width: 350px;
  }

  .main {
    background: -webkit-linear-gradient(top, #030000, #21222c);
  }

  .info_1 {
    margin-top: 100px;
    height: 300px;
    padding-top: 30px;
  }

  .info_1 img {
    float: left;
    margin-top: 25px;
    height: 200px;
  }

  .info_1 p {
    float: right;
    margin-right: -70px;
    font-size: 20px;
    width: 500px;
    text-align: left;
  }

  .info_2 {
    height: 300px;
  }

  .info_2 img {
    float: right;
    height: 200px;
    margin-top: 25px;
    margin-right: -70px;
  }

  .info_2 p {
    float: left;
    font-size: 20px;
    margin-top: 55px;
    width: 500px;
    text-align: left;
  }

  .info_3 {
    height: 300px;
  }

  .info_3 img {
    float: left;
    height: 200px;
  }

  .info_3 p {
    float: right;
    margin-right: -70px;
    margin-top: 40px;
    font-size: 20px;
    width: 500px;
    text-align: left;
  }

  .login_form {
    background: -webkit-linear-gradient(top, #191921, #373749);
    height: 400px;
  }

  footer {
    padding-top: 8px;
    height: 35px;
    background-color: #4e4e65;
  }

  footer:hover {
    background: #000;
  }

  footer a {
    text-decoration: none;
    font-family: "DejaVu Sans Condensed";
    color: #EFEFEA;
    font-size: 23px;
    font-weight: bold;
  }

  footer a:hover {
    color: yellow;
  }
</style>
