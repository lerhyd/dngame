<template>
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
              <datetime v-model="bornDate"></datetime>
              {{bornDate}}
            </label>
            <br>
            <input class="sub" type="submit" value="Создать"/>
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
</style>
