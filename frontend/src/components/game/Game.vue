<template>
  <div>
    {{checkIfConfirmed()}}
    {{updateLoginName()}}
    {{getUserInfo()}}
    {{hasProfile()}}
    <div v-if="!this.$store.getters.loginStatus">
      <p>
        Ваша почта ещё не подтверждена.
      </p>
      <form @submit.prevent="send">
        <input class="sub" type="submit" value="Отправить снова"/>
      </form>
    </div>

    <div v-if="this.$store.getters.loginStatus && this.$store.getters.hasProfile">
      <div class="header">
        <div v-for="user in this.$store.getters.user">
          <p>{{user.login }} {{ user.regDate}}</p>
        </div>
        <router-link class="settings_link" to="/settings">Contacts</router-link>
        <a class="settings_logout" href="/logout">Logout</a>
      </div>
      <div class="main">
        <button>Начать</button>
        <br>
        <button>Правила</button>
        <br>
        <button>Достижения</button>
        <br>
        <button>Удалить профиль</button>
      </div>
    </div>

    <div v-if="!this.$store.getters.hasProfile">
      <div class="header">
        <div v-for="user in this.$store.getters.user">
          <p>Your login: {{user.login}} Registration date: {{user.regDate}}</p>
        </div>
        <router-link class="settings_link" to="/settings">Contacts</router-link>
        <a class="settings_logout" href="/logout">Logout</a>
      </div>
      <div class="main">
        <form @submit.prevent="createProfile">
          <label class="first_label">
            Имя:
            <input type="text" v-model="name">
          </label>
          <br>
          <label class="second_label">
            Фамилия:
            <input type="text" v-model="surname">
          </label>
          <br>
          <label class="third_label">
            Отчество:
            <input type="text" v-model="patr">
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
            <datetime v-model="profile.bornDate"></datetime>
          </label>
          <br>
          <input class="sub" type="submit" value="Создать"/>
        </form>
      </div>
    </div>

  </div>
</template>

<script>
    export default {
      name: "Game",
      data () {
        return {
          profile: {
            name: '',
            surname: '',
            patr: '',
            sex: undefined,
            bornDate: ''
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

</style>
