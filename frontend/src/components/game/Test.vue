<template>

  <div>
    <Header></Header>
    <section>
      {{updateLoginName()}}
      {{hasProfile()}}
      {{getUserInfo()}}
      <div v-if="this.$store.getters.hasProfile">
        {{getProfile()}}
        <div v-for="user in this.$store.getters.user">
          <p>{{user.login}}</p>
          <p>{{user.regDate}}</p>
        </div>
        <!--<div v-for="profile in this.$store.getters.profile">-->
        <!--<p>{{profile.name}}</p>-->
        <!--<p>{{profile.surname}}</p>-->
        <!--<p>{{profile.patr}}</p>-->
        <!--<p>{{profile.sex}}</p>-->
        <!--<p>{{profile.bornDate}}</p>-->
        <!--</div>-->
        <button class="button16" @click="deleteProfile()" value="Удалить профиль"></button>
        <br>
        <router-link class="button16" to="/class">Играть</router-link>
      </div>

      <div v-if="!this.$store.getters.hasProfile">
        <div class="center-on-page">
          <form @submit.prevent="createProfile">
            <h1>Выбери себе Имя</h1>
            <div class="select">
              <select id="selector">
                <option class="name-options">༼つ◕_◕༽つ</option>
                <option class="name-options" v-for="item in this.$store.getters.criminalPeople" v-bind="item.id">{{item.id}} {{item.surname}} {{item.name}} {{item.patr}}</option>
              </select>
            </div>
            <datetime type="datetime" v-model="datetimeTheming" class="theme-orange"></datetime>
            <input class="sub" type="submit" value="Создать" @click="updateLoginName();hasProfile()"/>
            <!--<label class="first_label">-->
            <!--Имя:-->
            <!--<input type="text" v-model="profile.name">-->
            <!--</label>-->
            <!--<br>-->
            <!--<label class="second_label">-->
            <!--Фамилия:-->
            <!--<input type="text" v-model="profile.surname">-->
            <!--</label>-->
            <!--<br>-->
            <!--<label class="third_label">-->
            <!--Отчество:-->
            <!--<input type="text" v-model="profile.patr">-->
            <!--</label>-->
            <!--<br>-->
            <!--<label class="fourth_label">-->
            <!--Пол:-->
            <!--<select v-model="profile.sex">-->
            <!--<option disabled value="">Пожалуйста, выберите пол</option>-->
            <!--<option v-bind:value="true">Мужчина</option>-->
            <!--<option v-bind:value="false">Женщина</option>-->
            <!--</select>-->
            <!--</label>-->
            <!--<br>-->
            <!--<label class="fifth_label">-->
            <!--Дата Рождения:-->

            <!--<datetime v-model="profile.bornDate" type="datetime" format="yyyy-MM-dd HH:mm:ss"></datetime>-->
            <!--</label>-->
            <br>
          </form>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
  import Header from "@/components/main/Header";
  export default {
    components: {Header},
    name: "Test",
    data () {
      return {
        id: null,
      }
    },
    mounted: function() {
      this.$store.dispatch('getRandomPeople').then();
    },
    methods: {
      send () {
        this.$store.dispatch('sendToken').then();
      },
      checkIfConfirmed() {
        this.$store.dispatch('checkIfConfirmed').then();
      },
      getUserInfo() {
        this.$store.dispatch('getUser').then();
      },
      createProfile() {
        this.$store.dispatch('createProfile', {
          id: this.id,
        }).then();
      },
      getProfile() {
        this.$store.dispatch('getProfile').then();
      },
      deleteProfile() {
        this.$store.dispatch('deleteProfile').then();
      },
      hasProfile() {
        this.$store.dispatch('hasProfile').then();
      },
      updateLoginName() {
        this.$store.dispatch('getLoginName').then();
      }
    }
  }
</script>

<style lang="scss" type="text/scss">

  .theme-orange .vdatetime-popup {
    color: #440d0b;
  }

  .theme-orange {
    color: grey;
  }


  .theme-orange .vdatetime-popup__header,
  .theme-orange .vdatetime-calendar__month__day--selected > span > span,
  .theme-orange .vdatetime-calendar__month__day--selected:hover > span > span {
    background: #FF9800;
    /*color: green;*/
  }

  .theme-orange .vdatetime-year-picker__item--selected,
  .theme-orange .vdatetime-time-picker__item--selected,
  .theme-orange .vdatetime-popup__actions__button {
    color: #ff9800;
    /*color: grey;*/
  }


  .center-on-page {
    font-family: 'Hand';
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%,-50%);
  }
  h1 {
    text-align: center;
  }

  .name-options{
    font-family: 'Hand';
    font-size: xx-large;
  }
  /* Reset Select */
  #selector {
     -webkit-appearance: none;
     -moz-appearance: none;
     -ms-appearance: none;
    appearance: none;
    outline: 0;
    box-shadow: none;
    border: 0 !important;
    background: #2c3e50;
    background-image: none;
    width: 100%;
    height: 100%;
    margin: 0;
    padding: 0 0 0 .5em;
    color: #fff;
    cursor: pointer;
  }
  /* Custom Select */
  .select {
    position: relative;
    display: block;
    width: 20em;
    height: 3em;
    line-height: 3;
    background: #2c3e50;
    overflow: hidden;
    border-radius: .25em;
  }
  #selector::-ms-expand {
    display: none;
  }
  /* Arrow */
  .select::after {
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
  .select:hover::after {
    color: #62000c;
  }
  .select::after {
     -webkit-transition: .25s all ease;
     -o-transition: .25s all ease;
    transition: .25s all ease;
  }

  input {
    color: black;
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

</style>
