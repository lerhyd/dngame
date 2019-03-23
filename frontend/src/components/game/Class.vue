<template>
  <div id="app">
    <Header></Header>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <section class="left-section">
      <img src="../../assets/img/a1.png"/>
    </section>
    <section class="main-section">
      <div class="wrapper">
        <p class="p-teg">
          Выбери класс, за который будешь играть
        </p>
        <div style="display: inline-block; text-align: left">
          <input type="radio" id="kira" v-bind:value="true" v-model="gameClass.isKira" name="radio-group-type" required>
          <label for="kira">Убийца</label>
          <br>
          <input type="radio" id="agent" v-bind:value="false" v-model="gameClass.isKira" name="radio-group-type">
          <label for="agent">Агент</label>
        </div>
        <p class="p-teg">
          Выбери регион, в котором будет твой персонаж
        </p>

        <div id="center-select">
          <div class="select-custom">
            <select class="region-selector" v-model="gameRegion.continent">
              <option value="null" disabled>Континент</option>
              <option v-for="continent in this.$store.getters.continents" v-bind:value="continent">{{continent}}</option>
            </select>
          </div>

          <div class="select-custom">
            <select class="region-selector" v-model="gameRegion.country" v-if="gameRegion.continent!=null" @click="getRegionsWithCountries()">
              <option value="null" disabled>Страна</option>
              <option v-for="country in this.$store.getters.countries" v-bind:value="country">{{country}}</option>
            </select>
          </div>

          <div class="select-custom">
            <select class="region-selector" v-model="gameRegion.city" v-if="gameRegion.country!=null" @click="getRegionsWithCities()">
              <option value="null" disabled>Город</option>
              <option v-for="city in this.$store.getters.cities" v-bind:value="city">{{city}}</option>
            </select>
          </div>
        </div>
        <br>
        <button class="find-match-button" @click="classChoose()" value="Найти матч" v-if="gameClass.isKira != undefined && this.$store.getters.id != null">
          <a>Найти матч</a>
        </button>
      </div>
    </section>
    <section class="right-section">
      <img src="../../assets/img/a2.png"/>
    </section>
  </div>
</template>

<script>
  import Header from "@/components/main/Header";
  export default {
    name: "Class.vue",
    components: {Header},
    data() {
      return {
        gameClass: {
          isKira: undefined,
        },

        gameRegion: {
          regionId: null,
          country: null,
          continent: null,
          city: null
        }
      }
    },
    methods: {
      getRegionsWithContinents(){
        this.$store.dispatch('getRegionsWithContinents').then()
      },
      getRegionsWithCountries(){
        this.$store.dispatch('getRegionsWithCountries', {continent: this.gameRegion.continent}).then()
      },
      getRegionsWithCities(){
        this.$store.dispatch('getRegionsWithCities', {country: this.gameRegion.country}).then()
        this.$store.dispatch('getRegionId', {city: this.gameRegion.city}).then()
      },
      classChoose() {
        this.$store.dispatch('classChoose', {
          isKira: this.gameClass.isKira,
          regionId: this.$store.getters.id
        }).then();
      },
      setDefaultStatusOfChoosing(){
        this.$store.commit('setGameClassChooseStatus', 666);
      }
    },
    mounted() {
      this.getRegionsWithContinents();
      this.setDefaultStatusOfChoosing();
    }
  }
</script>

<style scoped>

  .find-match-button{
    height: 40px;
    display: inline;
    width: 200px;
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
    margin-bottom: 30px;
  }

  .find-match-button:hover a {
    font-size: 17px;
    mix-blend-mode: multiply;
  }

  .p-teg{font-size: large;}

  #center-select{display: inline-block;}

  .region-selector {
    outline: 0;
    box-shadow: none;
    border: 0 !important;
    background: #2c3e50;
    width: 100%;
    height: 100%;
    margin: 0;
    padding: 0 0 0 .5em;
    color: #fff;
    cursor: pointer;
  }

  .select-custom {
    position: relative;
    display: block;
    width: 200px;
    /*height: 3em;*/
    line-height: 2;
    background: #2c3e50;
    overflow: hidden;
    border-radius: .25em;
    margin-bottom: 10px;

  }
  .region-selector::-ms-expand {
    display: none;
  }
  /* Arrow */
  .select-custom::after {
    content: '\25BC';
    position: absolute;
    top: 0;
    right: 0;
    bottom: 0;
    padding: 0 1em;
    background: #34495e;
    pointer-events: none;
  }
  /* Transition */
  .select-custom:hover::after {
    color: #62000c;
  }
  .select-custom::after {
    -webkit-transition: .25s all ease;
    -o-transition: .25s all ease;
    transition: .25s all ease;
  }


  [type="radio"]:checked,
  [type="radio"]:not(:checked) {
    position: absolute;
    left: -9999px;
  }
  [type="radio"]:checked + label,
  [type="radio"]:not(:checked) + label
  {
    position: relative;
    padding-left: 30px;
    cursor: pointer;
    line-height: 25px;
    display: inline-block;
    margin-bottom: 7px;
    margin-left: 5px;
    font-size: 20px;
  }
  [type="radio"]:checked + label:before,
  [type="radio"]:not(:checked) + label:before {
    content: '';
    position: absolute;
    left: 0;
    top: 0;
    width: 18px;
    height: 18px;
    border: 1px solid #ddd;
    border-radius: 100%;
    background: #fff;
  }
  [type="radio"]:checked + label:after,
  [type="radio"]:not(:checked) + label:after {
    content: '';
    width: 12px;
    height: 12px;
    background: #62000c;
    position: absolute;
    top: 4px;
    left: 4px;
    border-radius: 100%;
    -webkit-transition: all 0.2s ease;
    transition: all 0.2s ease;
  }
  [type="radio"]:not(:checked) + label:after {
    opacity: 0;
    -webkit-transform: scale(0);
    transform: scale(0);
  }
  [type="radio"]:checked + label:after {
    opacity: 1;
    -webkit-transform: scale(1);
    transform: scale(1);
  }
  .button16 {
    display: inline-block;
    text-decoration: none;
    padding: 1em;
    outline: none;
    border-radius: 10px;
    font-size: medium;
    font-family: 'Hand';
    color: white;
  }
  .button16:hover {
    background-image:
      radial-gradient(3px 45% at 0% 50%, rgba(255, 255, 255, 0.6), transparent),
      radial-gradient(3px 45% at 100% 50%, rgba(255,255,255,.6), transparent);
  }
  .button16:active {
    background-image:
      radial-gradient(50% 50% at 50% 50%, rgba(74, 74, 74, 0.9), rgba(255,255,255,0));
  }


  .wrapper{
    display: inline-block;
    position: center;
    height: 90%;
    width: 60%;
    border: 5px solid rgb(254, 254, 254);
    border-radius: 30px;
  }

  #app{
    text-align: center;
    color: white;
    font-family: 'Hand';
  }

  section{
    display: inline-block;
    width: 25%;
    text-align: center;
  }

  section img{width: 100%;}
  .left-section{float: left;}

  .right-section{float: right;}

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

    .wrapper{width: 90%;}

    .wrapper ul{width: auto;}

    .left-section{display: none;}

    .right-section{display: none;}

    .main-section{width: 90%;}

    fieldset::after{right: 21%;}

    section img{display: none;}
  }

  @media screen and (min-width:701px) and (max-width: 1209px){
    .left-section{display: none;}

    .right-section{display: none;}

    .main-section{width: 95%;}
  }

</style>
