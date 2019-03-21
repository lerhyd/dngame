<template>
    <div>
      <!--killer's area-->
      <div v-if="this.$store.getters.isKira">
        <!--User's data-->
        <div>
          <div v-for="user in this.$store.getters.user">
            <p>{{user.login}}</p>
          </div>
          <div v-for="status in this.$store.getters.status">
            <p>points: {{status.points}}</p>
            <p>lvl: {{status.lvl}}</p>
            <p>rank: {{status.rank}}</p>
            <p>number of right kills: {{status.numberOfRightKills}}</p>
          </div>
        </div>
        <!--News-->
        <div>
          <div v-for="news in this.$store.getters.news">
            <p><b>Breaking news!</b></p>
            <p>Дата публикации: {{news.pubDate}}</p>
            <p>Заголовок: {{news.description}}</p>
            <p>Что случилось: {{news.victimSex ? 'мужчина' : 'женщина'}}
              {{news.victimName}} {{news.victimSurname}} {{news.victimPatr}} {{news.actionDesc}}
            </p>
            <p v-if="news.isGuiltyPersonExists == true">Предполагаемый виновный:
              {{news.guiltyPersonSex ? 'мужчина' : 'женщина'}} {{news.guiltyPersonName}}
              {{news.guiltyPersonSername}} {{news.guiltyPersonPatr}}
            </p>
            <p>Место происшествия: {{news.actionPlace}}</p>
          </div>
        </div>
        <!--Actions-->
        <div>

        </div>
      </div>

      <!--agent's area-->
      <div v-if="!this.$store.getters.isKira">

        <!--User's data-->
        <div>
          <div v-for="user in this.$store.getters.user">
            <p>{{user.login}}</p>
          </div>
          <div v-for="status in this.$store.getters.status">
            <p>points: {{status.points}}</p>
            <p>lvl: {{status.lvl}}</p>
            <p>rank: {{status.rank}}</p>
            <p>number Of Caught Killers: {{status.numberOfCaughtKillers}}</p>
          </div>
        </div>
        <!--News-->
        <div>
          <div v-for="news in this.$store.getters.news">
            <p><b>Breaking news!</b></p>
            <p>Дата публикации: {{news.pubDate}}</p>
            <p>Заголовок: {{news.description}}</p>
            <p>Что случилось: {{news.victimSex ? 'мужчина' : 'женщина'}}
              {{news.victimName}} {{news.victimSurname}} {{news.victimPatr}} {{news.actionDesc}}
            </p>
            <p v-if="news.isGuiltyPersonExists == true">Предполагаемый виновный:
              {{news.guiltyPersonSex ? 'мужчина' : 'женщина'}} {{news.guiltyPersonName}}
              {{news.guiltyPersonSername}} {{news.guiltyPersonPatr}}
            </p>
            <p>Место происшествия: {{news.actionPlace}}</p>
          </div>
        </div>
        <!--Actions-->
        <div>

        </div>
      </div>
    </div>
</template>

<script>
  export default {
    name: "Area",
    methods: {
      getKiraStatus(){
        this.$store.dispatch('getKiraStatus')
      },
      getAgentStatus(){
        this.$store.dispatch('getAgentStatus')
      },
      getKiraNews(){
        this.$store.dispatch('getKiraNews')
      },
      getAgentNews(){
        this.$store.dispatch('getAgentNews')
      },
      getNews(){
        if (this.$store.getters.isKira)
          this.$store.dispatch('getKiraNews')
        else
          this.$store.dispatch('getAgentNews')
      },
      getStatus(){
        if (this.$store.getters.isKira)
          this.$store.dispatch('getKiraStatus')
        else
          this.$store.dispatch('getAgentStatus')
      }
    },
    mounted() {
      this.getStatus()
      this.getNews()
    }
  }
</script>

<style scoped>

</style>
