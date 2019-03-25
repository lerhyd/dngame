<template>
  <div id="main-div">
      <!--<img src="../../assets/img/computer3.png">-->
      <Header></Header>
      <UserData></UserData>
      <div id="news-area" v-bind:style="styleObject" >
        <div v-for="news in this.$store.getters.news">
          <p><b>Свежайшие новости!</b></p>
          <a>Дата публикации: {{news.pubDate}}</a><br><br>
          <a>Заголовок: {{news.description}}</a><br><br>
          <a>Что случилось: {{news.victimSurname}} {{news.victimName}} {{news.victimPatr}} {{news.actionDesc}}
          </a><br><br>
          <a v-if="news.isGuiltyPersonExists == true">Предполагаемый виновный: {{news.guiltyPersonSurname}} {{news.guiltyPersonName}} {{news.guiltyPersonPatr}}
          </a><br><br>
          <a>Место происшествия: {{news.actionPlace}}</a>
        </div>
      </div>

      <section id="main-control-section">
        <button class="menu-buttons" v-if="isNoteOpen===false" @click="openNote()"><a>Открыть планшет</a></button>
        <button class="menu-buttons" v-if="isNoteOpen===true" @click="closeNote();closeEntryForm()"><a>Закрыть планшет</a></button>
        <button class="menu-buttons" v-if="isNoteOpen===true && isEntriesOpen===false" @click="getRequestPages();getRequests();openEntries()"><a>Посмотреть запросы в полицию</a></button>
        <button class="menu-buttons" v-if="isEntriesOpen===true && isNoteOpen===true" @click="closeEntries()">Закрыть запросы в полицию</button>
        <select v-if="isEntriesOpen===true && isNoteOpen===true" class="menu-buttons" v-model="numPage">
          <option disabled selected>Выберите страницу</option>
          <option v-for="number in this.$store.getters.entryPages" v-bind:value="number">{{number}}</option>
        </select>
        <button class="menu-buttons" v-if="isNoteOpen===true && isEntryFormOpen===false" @click="openEntryForm()">Открыть форму запроса</button>
        <button class="menu-buttons" v-if="isEntryFormOpen===true" @click="closeEntryForm()">Закрыть форму запроса</button>
        <button class="menu-buttons" v-if="isNoteOpen===true && isFakeNewsOpen===false" @click="openFakeNews();getActions();getActionPlaces()">Создать фальшивую новость</button>
        <button class="menu-buttons" v-if="isFakeNewsOpen===true" @click="closeFakeNews();clearNews()">Закрыть раздел создания новостей</button>
      </section>

      <aside id="main-aside">
        <div id="tablet-paper" v-if="isNoteOpen===true">
          <div id="tablet-content">
            <div v-if="isEntriesOpen===true">
              <div v-for="entry in this.$store.getters.entry">
                <p>{{entry.personSurname}} {{entry.personName}}  {{entry.personPatr}} {{entry.success ? 'пойман':'не пойман'}}
                </p>
              </div>
            </div>
            <div v-if="isEntryFormOpen===true">
              Введите ФИО человека, информацию по которому вы хотите запросить<br><br>
              <input class="form-tablet-input" type="text" v-model="entryForm.victimSurname" placeholder="Фамилия человека" pattern="[A-Za-zА-Яа-яЁё]" required>
              <input class="form-tablet-input" type="text" v-model="entryForm.victimName" placeholder="Имя человека" pattern="[A-Za-zА-Яа-яЁё]" required>
              <input class="form-tablet-input" id="patr-field-tablet" type="text" v-model="entryForm.victimPatr" placeholder="Отчество человека" pattern="[A-Za-zА-Яа-яЁё]" required>

              <input type="radio" id="man" name="radio-group" v-model="entryForm.victimSex" v-bind:value="true" required>
              <label for="man">Мужчина</label>
              <input type="radio" id="woman" name="radio-group" v-model="entryForm.victimSex" v-bind:value="false">
              <label for="woman">Женщина</label>
              <button type="submit"  id="make-a-note" @click="makeRequest();closeEntryForm();clearForm();closeEntries();closeNote()"><a>Сделать запись</a></button>
              <br>
              <div v-if="this.$store.getters.entryStatus !== 0" id="error-div-form">
                <p v-if="this.$store.getters.entryStatus === 7">Такой запрос уже существует</p>
                <p v-if="this.$store.getters.entryStatus === 8">Пользователя с такими данными не существует</p>
                <p v-if="this.$store.getters.entryStatus === 9">Идентификация человека не совпадает с базой данных</p>
              </div>
            </div>
            <div v-if="isFakeNewsOpen===true">
              <input class="form-tablet-input" type="text" v-model="entryForm.desc" placeholder="Описание новости" required>
              <datetime
                v-model="entryForm.deathDate"
                :phrases="{ok: 'Подтвердить', cancel: 'Отмена'}"
                id="date-label" type="datetime"
                class="red-theme"
                :min-datetime="minDatetime"
                :max-datetime="maxDatetime" auto>
                <label for="date-label" slot="before">Дата и время публикации:</label>
              </datetime>
              <p class="select-form">Выберите действие:
                <select class="form-control-tablet" v-model="entryForm.actionId" required>
                  <option v-for="action in this.$store.getters.action" v-bind:value="action.id">{{action.desc}}</option>
                </select>
              </p>
              <p class="select-form">Выберите место действия:
                <select class="form-control-tablet" v-model="entryForm.actionPlaceId" required>
                  <option v-for="actionPlace in this.$store.getters.actionPlace" v-bind:value="actionPlace.id">{{actionPlace.place}}</option>
                </select>
              </p>
              <p>Выберете регион, где всё произошло.
              <select class="form-control-tablet" v-model="commonRegion.continent">
                <option value="null" disabled>Континент</option>
                <option v-for="continent in this.$store.getters.continents" v-bind:value="continent">{{continent}}</option>
              </select>
              <select class="form-control-tablet" v-model="commonRegion.country" v-if="commonRegion.continent!=null">
                <option value="null" disabled>Страна</option>
                <option v-for="country in this.$store.getters.countries" v-bind:value="country">{{country}}</option>
              </select>
              <select class="form-control-tablet" v-model="commonRegion.city" v-if="commonRegion.country!=null">
                <option value="null" disabled>Город</option>
                <option v-for="city in this.$store.getters.cities" v-bind:value="city">{{city}}</option>
              </select>
              </p>
              <p>Выберете регион, на который будут распространяться новости.
                <br>
                <select class="form-control-tablet" v-model="distRegion.continent">
                  <option value="null" >Континент</option>
                  <option v-for="continent in this.$store.getters.distContinents" v-bind:value="continent">{{continent}}</option>
                </select>
                <select class="form-control-tablet" v-model="distRegion.country" v-if="distRegion.continent!=null">
                  <option value="null" >Страна</option>
                  <option v-bind:value="0">Нет</option>
                  <option v-for="country in this.$store.getters.distCountries" v-bind:value="country">{{country}}</option>
                </select>
                <select class="form-control-tablet" v-model="distRegion.city" v-if="distRegion.country!=null">
                  <option value="null" >Город</option>
                  <option v-bind:value="0">Нет</option>
                  <option v-for="city in this.$store.getters.distCities" v-bind:value="city">{{city}}</option>
                </select>
              </p>
              <p>Выберите виновного:
              <select class="form-control-tablet" v-model="newsForm.guiltyPersonId">
                <option v-for="person in this.$store.getters.persons" v-bind:value="person.id">
                  {{person.surname}} {{person.name}} {{person.patr}}
                </option>
              </select>
              </p>
              <p v-if="newsForm.guiltyPersonId !== 0">Выберите пострадавшего(не обязательно).</p>
              <div v-if="newsForm.guiltyPersonId !== 0">
                <select class="form-control-tablet" v-model="newsForm.victimId">
                  <option v-for="person in this.$store.getters.victimPersons" v-bind:value="person.id">
                    {{person.name}} {{person.surname}} {{person.patr}}
                  </option>
                </select>
              </div>
              <button class="form-tablet-input" @click="createFakeNews();closeFakeNews();clearNews()">Создать новость</button>
            </div>
          </div>
        </div>
      </aside>

    <div v-if="this.$store.getters.matchEnded">
      <div v-if="this.$store.getters.isKira">
        <div v-if="this.$store.getters.isKiraWin && !this.$store.getters.isGameDrawn">
          Вы победили.
        </div>
        <div v-if="!this.$store.getters.isKiraWin && !this.$store.getters.isGameDrawn">
          Вы проиграли.
        </div>
        <div v-if="this.$store.getters.isGameDrawn">
          Ничья.
        </div>
      </div>
      <div v-if="!this.$store.getters.isKira">
        <div v-if="!this.$store.getters.isKiraWin && !this.$store.getters.isGameDrawn">
          Вы победили.
        </div>
        <div v-if="this.$store.getters.isKiraWin && !this.$store.getters.isGameDrawn">
          Вы проиграли.
        </div>
        <div v-if="this.$store.getters.isGameDrawn">
          Ничья.
        </div>
      </div>
      <button class="button16" @click="exit()">Вернутся в меню выбора</button>
    </div>

  </div>
</template>

<script>
  import Header from "@/components/main/Header";
  import UserData from "@/components/game/UserData";
  import { DateTime as LuxonDateTime } from 'luxon';
  export default {
    components: {UserData, Header},
    name: "Agent",
    data() {
      return {
        isNoteOpen: false,
        isEntriesOpen: false,
        isEntryFormOpen: false,
        isFakeNewsOpen: false,
        distRegionStatus: true,
        numPage: 1,
        entryForm: {
          desc: '',
          deathDate: null,
          actionId: null,
          actionPlaceId: null,

          victimName: '',
          victimSurname: '',
          victimPatr: '',
          victimSex: undefined
        },
        newsForm: {
          distRegionId: null,
          victimId: 0,
          guiltyPersonId: 0
        },
        commonRegion: {
          regionId: null,
          country: null,
          continent: null,
          city: null
        },
        distRegion: {
          regionId: null,
          country: null,
          continent: null,
          city: null
        },
        styleObject: {
          position: 'absolute',
          height: window.innerHeight * 0.42 + 'px',
          width: window.innerWidth * 0.36 + 'px',
          top: window.innerHeight * 0.16 + 'px',
          left: window.innerWidth * 0.207 + 'px',
        },
        minDatetime: LuxonDateTime.local().plus({seconds: 40}).toISO(),
        maxDatetime: LuxonDateTime.local().plus({ days: 2 }).toISO(),
      }
    },
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
        if (this.$store.getters.isKira) {
          this.$store.dispatch('getKiraNews')
        }
        else {
          this.$store.dispatch('getAgentNews')
        }
      },
      getStatus(){
        console.log(this.$store.getters.isKira)
        if (this.$store.getters.isKira)
          this.$store.dispatch('getKiraStatus')
        else
          this.$store.dispatch('getAgentStatus')
      },
      openNote(){
        this.isNoteOpen = true
      },
      closeNote(){
        this.isNoteOpen = false
      },
      openEntryForm(){
        this.isEntryFormOpen = true
        this.isFakeNewsOpen = false
        this.isEntriesOpen = false
      },
      closeEntryForm(){
        this.isEntryFormOpen = false
      },
      openEntries(){
        this.isEntriesOpen = true
        this.isEntryFormOpen = false
        this.isFakeNewsOpen = false

      },
      closeEntries(){
        this.isEntriesOpen = false
      },
      openFakeNews(){
        this.isFakeNewsOpen = true
        this.isEntryFormOpen = false
        this.isEntriesOpen = false
      },
      closeFakeNews(){
        this.isFakeNewsOpen = false
      },
      getEntryPages() {
        this.$store.dispatch('getEntryPages')
      },
      getEntries() {
        this.$store.dispatch('getEntries')
      },
      getRequests() {
        this.$store.dispatch('getRequests')
      },
      getRequestPages() {
        this.$store.dispatch('getRequestPages')
      },
      makeEntry() {
        this.$store.dispatch('makeEntry',
          {
            actionId: this.entryForm.actionId,
            victimName: this.entryForm.victimName,
            victimSurname: this.entryForm.victimSurname,
            victimPatr: this.entryForm.victimPatr,
            victimSex: this.entryForm.victimSex,
            desc: this.entryForm.desc,
            deathDate: this.entryForm.deathDate,
            actionPlaceId: this.entryForm.actionPlaceId
          }
        )
      },

      makeRequest() {
        this.$store.dispatch('makeRequest',
          {
            victimName: this.entryForm.victimName,
            victimSurname: this.entryForm.victimSurname,
            victimPatr: this.entryForm.victimPatr,
            victimSex: this.entryForm.victimSex,
          }
        )
      },
      getActions(){
        if (this.$store.getters.isKira)
          this.$store.dispatch('getKiraActions')
        else
          this.$store.dispatch('getAgentActions')
      },
      getActionPlaces(){
        if (this.$store.getters.isKira)
          this.$store.dispatch('getKiraActionPlaces')
        else
          this.$store.dispatch('getAgentActionPlaces')
      },
      clearForm(){
        this.entryForm.actionId = null
        this.entryForm.victimName = ''
        this.entryForm.victimSurname = ''
        this.entryForm.victimPatr = ''
        this.entryForm.victimSex = undefined
        this.entryForm.desc = ''
        this.entryForm.deathDate = null
        this.entryForm.actionPlaceId = null
      },
      kiraWin(){
        this.$store.dispatch('kiraWin')
      },
      agentWin(){
        this.$store.dispatch('agentWin')
      },
      exit(){
        router.push("/game")
      },

      getPersons(){
        this.$store.dispatch('getPersons',
          {
            usedPerson: this.newsForm.guiltyPersonId
          }
        )
      },
      getVictimPersons(){
        this.$store.dispatch('getVictimPersons',
          {
            usedPerson: this.newsForm.guiltyPersonId
          }
        )
      },
      createFakeNews(){
        this.$store.dispatch('createFakeNews',
          {
            desc: this.entryForm.desc,
            pubDate: this.entryForm.deathDate,
            actionId: this.entryForm.actionId,
            actionPlaceId: this.entryForm.actionPlaceId,
            commonRegionId: this.$store.getters.id,
            distRegionId: this.$store.getters.distId,
            victimId: this.newsForm.victimId,
            guiltyPersonId: this.newsForm.guiltyPersonId
          }
        )
      },
      getCommonRegionsWithContinents(){
        this.$store.dispatch('getRegionsWithContinents').then()
      },
      getCommonRegionsWithCountries(){
        this.$store.dispatch('getRegionsWithCountries', {continent: this.commonRegion.continent}).then()
      },
      getCommonRegionsWithCities(){
        this.$store.dispatch('getRegionsWithCities', {country: this.commonRegion.country}).then()
      },
      getCommonRegionId(){
        this.$store.dispatch('getRegionId', {city: this.commonRegion.city}).then()
      },

      getDistRegionsWithContinents(){
        this.$store.dispatch('getDistContinents').then()
      },
      getDistRegionsWithCountries(){
        this.$store.dispatch('getDistRegionsWithCountries', {continent: this.distRegion.continent}).then()
      },
      getDistRegionsWithCities(){
        this.$store.dispatch('getDistRegionsWithCities', {country: this.distRegion.country}).then()
      },
      getFullRegionId(){
        this.$store.dispatch('getFullRegionId',
          {
            city: this.distRegion.city,
            country: this.distRegion.country,
            continent: this.distRegion.continent
          }
        )
      },
      clearNews(){
        this.entryForm.desc = ''
        this.entryForm.pubDate = null
        this.entryForm.actionId = null
        this.entryForm.actionPlaceId = null
        this.newsForm.commonRegionId = null
        this.newsForm.distRegionId = null
        this.newsForm.victimId = null
        this.newsForm.guiltyPersonId = 0
      }
    },
    mounted() {
      this.getStatus()
      this.getNews()
      this.getCommonRegionsWithContinents();
      this.getDistRegionsWithContinents();
    },
    watch: {
      numPage: function (val) {
        this.$store.commit('setNumPage', val)
        if (this.$store.getters.isKira())
          this.getEntries()
        else
          this.getRequests()
      },
      'commonRegion.continent': function (val) {
        this.commonRegion.country = null
        this.commonRegion.city = null
        this.getCommonRegionsWithCountries()
      },
      'commonRegion.country': function (val) {
        this.commonRegion.city = null
        this.getCommonRegionsWithCities()

      },
      'commonRegion.city': function (val) {
        console.log('')
        this.getCommonRegionId()
      },
      'distRegion.continent': function (val) {
        this.distRegion.country = 0
        this.distRegion.city = 0
        this.getDistRegionsWithCountries()
      },
      'distRegion.country': function (val) {
        this.distRegion.city = 0
        this.getDistRegionsWithCities()
      },
      'distRegion.city': function (val) {
        console.log('')
        this.getFullRegionId()
      },
      'newsForm.guiltyPersonId': function (val) {
        this.getVictimPersons()
      }
    }
  }
</script>

<style>

  #error-div-form{
    color: #880000;
    font-weight: bold;
    text-align: center;
  }

  .select-form{
    display: block;
  }
  .form-control-tablet{
    border: transparent;
    /*margin-bottom: 5px;*/
    margin-right: 10px;
    font-family:helvetica neue, helvetica, arial, sans-serif;
    font-weight: 300;
    color: black;
    font-size: 20px;
    user-focus: none;
    background: none;
    outline: none;

  }

  #make-a-note{
    height: 30px;
    margin-top: 25px;
    display: inline;
    width: 100%;
    font-family:helvetica neue, helvetica, arial, sans-serif;
    font-weight: 400;
    cursor: pointer;
    font-size: 20px;
    /*color: #111111;*/
    /*border-radius: 6px;*/
    border: none;
    user-focus: none;
    background: none;
    outline: none;
  }

  .menu-buttons{
    height: 40px;
    display: inline;
    width: 170px;
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
    color: black;
  }


  #tablet-paper {
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    -ms-box-sizing: border-box;
    -o-box-sizing: border-box;
    box-sizing: border-box;
    background: #f1f1f1;
    font-family: helvetica neue, helvetica, arial, sans-serif;
    font-weight: 200;
    width: 95%;
    height: 600px;
    margin: 0px auto;
    position: relative;
    padding-left: 8%;
    padding-right: 20px;
    overflow-y: scroll;
    border-radius: 50px;
    border: 30px dimgrey solid;
  }

  #tablet-content {
    margin-top:5px;
    font-size:20px;
    line-height:30px;}

  #tablet-content p {
    margin:0 0 30px 0;
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
    background-color: #111111;
    background-repeat: no-repeat;
  }

  .form-tablet-input{
    border: transparent;
    display: block;
    width: 100%;
    margin-bottom: 5px;
    font-family:helvetica neue, helvetica, arial, sans-serif;
    color: black;
    font-size: 20px;
    user-focus: none;
    background: none;
    outline: none;
    /*font-weight: lighter;*/
  }

  .form-tablet-input::placeholder{
    font-size: 20px;
    font-family:helvetica neue, helvetica, arial, sans-serif;
    color: black;
    /*text-decoration: none;*/
    font-weight: 200;
  }

  #main-control-section {
    float: left;
    margin: 0 1%;
    width: 15%;
  }
  #main-aside {
    color: black;
    float: right;
    width: 80%;
  }


  [type="radio"]:checked,
  [type="radio"]:not(:checked) {
    position: absolute;
    left: -9999px;
    font-weight: 200;

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
    font-weight: 200;
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
    font-weight: 200;

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
    font-weight: 200;

  }
  [type="radio"]:not(:checked) + label:after {
    opacity: 0;
    font-weight: 200;

    -webkit-transform: scale(0);
    transform: scale(0);
  }
  [type="radio"]:checked + label:after {
    opacity: 1;
    font-weight: 200;

    -webkit-transform: scale(1);
    transform: scale(1);
  }

  #patr-field-tablet{
    margin-bottom: 0px;
  }

  .red-theme .vdatetime-popup__header,
  .red-theme .vdatetime-calendar__month__day--selected > span > span,
  .red-theme .vdatetime-calendar__month__day--selected:hover > span > span {
    background: #880807;
  }

  .red-theme{
    user-focus: none;
    background: none;
    outline: none;
    margin-top: 0px;
    border: none;
  }


  .red-theme .vdatetime-year-picker__item--selected,
  .red-theme .vdatetime-time-picker__item--selected,
  .red-theme .vdatetime-popup__actions__button {
    color: #880807;
  }


</style>
