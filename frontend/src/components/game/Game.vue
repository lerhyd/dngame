<template>
  <div>
    <Header></Header>
    {{updateLoginName()}}
    {{hasProfile()}}
    <header></header>
    <section class="main-section">
      <div v-if="this.$store.getters.hasProfile">
        <div v-for="user in this.$store.getters.user">
          <p>{{user.login}} {{user.regDate}}</p>
        </div>
        <div v-for="profile in this.$store.getters.profile">
          <p>{{profile.name}}</p>
          <p>{{profile.surname}}</p>
          <p>{{profile.patr}}</p>
          <p>{{profile.sex}}</p>
          <p>{{profile.bornDate}}</p>
        </div>
        <button class="button16" @click="deleteProfile()">Удалить профиль</button>
        <br>
        <router-link class="button16" to="/class">Играть</router-link>
      </div>

      <div v-if="!this.$store.getters.hasProfile">
          <div class="center-on-page">
          <form id="profile-form" @submit.prevent="createProfile">
            <h1>Создание профиля</h1>
            <input class="form-profile-input" type="text" placeholder="Имя" v-model="profile.name" pattern="[A-Za-zА-Яа-яЁё]{1,20}" required>
            <br>
            <input class="form-profile-input" type="text" placeholder="Фамилия" v-model="profile.surname" pattern="[A-Za-zА-Яа-яЁё]{1,20}" required>
            <br>
            <input class="form-profile-input" type="text" placeholder="Отчество" v-model="profile.patr" pattern="[A-Za-zА-Яа-яЁё]{1,20}">
            <br>
            <br>
            <input type="radio" id="man" v-bind:value="true" v-model="profile.sex" name="radio-group" required>
            <label for="man">Мужчина</label>
            <br>
            <input type="radio" id="woman" v-bind:value="false" v-model="profile.sex" name="radio-group">
            <label for="woman">Женщина</label>
            <br>
              <datetime
                :phrases="{ok: 'Подтвердить', cancel: 'Отмена'}"
                id="date-label" type="date"
                v-bind:value="profile.bornDate"
                class="red-theme"
                :min-datetime="minDatetime"
                :max-datetime="maxDatetime" auto
              >
                <label for="date-label" slot="before" id="birthday-label" >Дата Рождения:</label>
              </datetime>
            <br>
            <button class="submit" type="submit" @click="updateLoginName();hasProfile();getUserInfo()">
              <a>Создать</a>
            </button>

          </form>
          </div>
      </div>
    </section>
  </div>
</template>

<script>
  import Header from "@/components/main/Header";
  import { DateTime as LuxonDateTime } from 'luxon'
  export default {
    components: {Header},
    name: "Game",
    data () {
      return {
        minDatetime: LuxonDateTime.local().minus({years: 100}).toISO(),
        maxDatetime: LuxonDateTime.local().minus({ years: 18 }).toISO(),
        profile: {
          name: '',
          surname: '',
          patr: '',
          sex: true,
          bornDate: null,
        }
      }
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
          name: this.profile.name,
          surname: this.profile.surname,
          patr: this.profile.patr,
          sex: this.profile.sex,
          bornDate: this.profile.bornDate
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
        if (this.$store.getters.hasProfile)
          this.getProfile()
      },
      updateLoginName() {
        this.$store.dispatch('getLoginName').then();
      }
    },
    mounted() {
      this.updateLoginName()
      this.getUserInfo()
      this.hasProfile()
      this.getProfile()
    }
  }
</script>

<style lang="scss" type="text/scss">

  #birthday-label{
    font-size: 20px;
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

  .submit{
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

  .submit:hover a {
    font-size: 17px;
    mix-blend-mode: multiply;
  }


  /*#profile-form{*/
    /*display: inherit;*/
    /*padding-bottom: 5%;*/
  /*}*/

  .red-theme .vdatetime-popup__header,
  .red-theme .vdatetime-calendar__month__day--selected > span > span,
  .red-theme .vdatetime-calendar__month__day--selected:hover > span > span {
    background: #880807;
  }

  .red-theme{
    /*width: 500px;*/

    font-family: 'Hand';
    color: white;
    user-focus: none;
    background: none;
    outline: none;
    margin-top: 5px;
    /*font-size: 20px;*/
  }

  html{
    color: white;
  }

  .red-theme .vdatetime-year-picker__item--selected,
  .red-theme .vdatetime-time-picker__item--selected,
  .red-theme .vdatetime-popup__actions__button {
    color: #880807;
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

  .form-profile-input{
    font-family: 'Hand';
    color: white;
    width: 270px;
    height: 35px;
    border-radius: .25em;
    /*border: 1px solid white;*/
    user-focus: none;
    background: none;
    outline: none;
    margin-top: 10px;
    font-size: 20px;
    transition: all 0.5s linear;
  }

  .form-profile-input:hover{
    background: rgb(222, 222, 222);
    box-shadow: 0 0 300px 1px #c0c0c0;
    /*border: 1px solid #474A59;*/
    color: #111111;
  }

  .form-profile-input:hover::placeholder{
    color: #111111;
  }

  ::placeholder {color: white;}

  .form-profile-input::selection{
    color: white;
    background: #474A59;
  }

  .form-profile-input:focus::placeholder{
    color: transparent;
  }

  .center-on-page{
    font-family: 'Hand';
    display: inline-block;
    position: center;
    height: 90%;
    width: 60%;
  }

  h1 {
    text-align: center;
    font-size: xx-large;
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
