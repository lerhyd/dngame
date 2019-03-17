<template>
<<<<<<< HEAD

  <div>
    <header></header>
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
        <div v-for="profile in this.$store.getters.profile">
          <p>{{profile.name}}</p>
          <p>{{profile.surname}}</p>
          <p>{{profile.patr}}</p>
          <p>{{profile.sex}}</p>
          <p>{{profile.bornDate}}</p>
        </div>
        <button class="button16" @click="deleteProfile()" value="Удалить профиль"></button>
=======
  {{updateLoginName()}}
  {{getUserInfo()}}
  {{hasProfile()}}
  <div>
    <header></header>
    <section>
      <div v-if="this.$store.getters.hasProfile">
        <div v-for="user in this.$store.getters.user">
          <p>{{user.login }}</p>
          <p>{{user.regDate}}</p>
        </div>
>>>>>>> 5394f71599c0d0d13dedba123fbd95e851a72227
      </div>

      <div v-if="!this.$store.getters.hasProfile">
        <div class="main">
          <form @submit.prevent="createProfile">
            <label class="first_label">
              Имя:
              <input type="text" v-model="profile.name">
            </label>
            <br>
            <label class="second_label">
              Фамилия:
              <input type="text" v-model="profile.surname">
            </label>
            <br>
            <label class="third_label">
              Отчество:
              <input type="text" v-model="profile.patr">
            </label>
            <br>
            <label class="fourth_label">
              Пол:
              <select v-model="profile.sex">
                <option disabled value="">Пожалуйста, выберите пол</option>
                <option v-bind:value="true">true</option>
                <option v-bind:value="false">false</option>
              </select>
            </label>
            <br>
            <label class="fifth_label">
              Дата Рождения:
<<<<<<< HEAD
              <datetime v-model="profile.bornDate" type="datetime" format="yyyy-MM-dd HH:mm:ss"></datetime>
            </label>
            <br>
            <input class="sub" type="submit" value="Создать" @click="updateLoginName();hasProfile()"/>
=======
              <datetime v-model="bornDate"></datetime>
              {{bornDate}}
            </label>
            <br>
            <input class="sub" type="submit" value="Создать"/>
>>>>>>> 5394f71599c0d0d13dedba123fbd95e851a72227
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
    name: "Game",
    data () {
      return {
        profile: {
          name: '',
          surname: '',
          patr: '',
          sex: false,
          bornDate: null
        },
        class: {
          isKira: undefined,
          regionId: undefined
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
      classChoose() {
        this.$store.dispatch('classChoose', {
          isKira: this.class.isKira,
          regionId: this.class.regionId
        }).then();
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

<style scoped>
<<<<<<< HEAD
 * {
   color: white;
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
=======
>>>>>>> 5394f71599c0d0d13dedba123fbd95e851a72227
</style>
