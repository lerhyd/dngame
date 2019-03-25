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
      <button class="menu-buttons" v-if="isNoteOpen===false" @click="openNote();getActions();getActionPlaces()"><a>Открыть тетрадь</a></button>
      <button class="menu-buttons" v-if="isNoteOpen===true"@click="closeNote();closeEntryForm()">Закрыть тетрадь</button>
      <button class="menu-buttons" v-if="isNoteOpen===true && isEntriesOpen===false" @click="getEntryPages();getEntries();openEntries()"><a>Посмотреть записи</a></button>
      <button v-if="isEntriesOpen===true && isNoteOpen===true" class="menu-buttons" @click="closeEntries()"><a>Закрыть записи</a></button>
      <select v-if="isEntriesOpen===true && isNoteOpen===true" class="menu-buttons" v-model="numPage">
        <option disabled selected>Выберите страницу</option>
        <option v-for="number in this.$store.getters.entryPages" v-bind:value="number">{{number}}</option>
      </select>
      <button class="menu-buttons" v-if="isNoteOpen===true && isEntryFormOpen===false" @click="openEntryForm()">Открыть форму записи</button>
      <button class="menu-buttons" v-if="isEntryFormOpen===true" @click="closeEntryForm()">Закрыть форму записи</button>
    </section>

    <aside id="main-aside">
      <div id="notebook-paper" v-if="isNoteOpen===true">
        <div id="content">
          <div v-if="isEntriesOpen===true">
            <div v-for="entry in this.$store.getters.entry">
              <p>{{entry.victimSurname}} {{entry.victimName}} {{entry.victimPatr}} {{entry.deathReason}} {{entry.deathPlace}}. Время:
                {{entry.deathDataTime}}.<br>{{entry.desc}}.</p>
            </div>
          </div>
          <div v-if="isEntryFormOpen===true">
            Введите ФИО человека, которого хотите убить<br><br>
            <input class="form-note-input" type="text" v-model="entryForm.victimSurname" placeholder="Фамилия человека" pattern="[A-Za-zА-Яа-яЁё]" required>
            <input class="form-note-input" type="text" v-model="entryForm.victimName" placeholder="Имя человека" pattern="[A-Za-zА-Яа-яЁё]" required>
            <input class="form-note-input" id="patr-field" type="text" v-model="entryForm.victimPatr" placeholder="Отчество человека" pattern="[A-Za-zА-Яа-яЁё]" required>
            <input type="radio" id="man" name="radio-group" v-model="entryForm.victimSex" v-bind:value="true" required>
            <label for="man">Мужчина</label>
            <input type="radio" id="woman" name="radio-group" v-model="entryForm.victimSex" v-bind:value="false">
            <label for="woman">Женщина</label>
            <input class="form-note-input" id="death-description" type="text" v-model="entryForm.desc" placeholder="Описание смерти" required>
            <br>
            <datetime
              v-model="entryForm.deathDate"
              :phrases="{ok: 'Подтвердить', cancel: 'Отмена'}"
              id="date-label" type="datetime"
              class="red-theme"
              :min-datetime="minDatetime"
              :max-datetime="maxDatetime" auto>
              <label for="date-label" slot="before">Дата и время смерти:</label>
            </datetime>
            <br>
            <p class="select-form">Причина смерти:
            <select class="form-control" v-model="entryForm.actionId" required>
              <option v-for="action in this.$store.getters.action" v-bind:value="action.id">{{action.desc}}</option>
            </select>
            </p>
            <p class="select-form">Место смерти:
            <select class="form-control" v-model="entryForm.actionPlaceId" required>
              <option v-for="actionPlace in this.$store.getters.actionPlace" v-bind:value="actionPlace.id">{{actionPlace.place}}</option>
            </select>
            </p>
            <button type="submit" id="make-a-note" @click="makeEntry();closeEntryForm();clearForm();closeEntries();closeNote()"><a>Записать?</a></button>
            <br>
            <div v-if="this.$store.getters.entryStatus !== 0" id="error-div-form">
              <p v-if="this.$store.getters.entryStatus === 1">Описание не может превышать 50 символов</p>
              <p v-if="this.$store.getters.entryStatus === 4">Неверная дата смерти</p>
              <p v-if="this.$store.getters.entryStatus === 10">Такая запись уже существует</p>
            </div>
          </div>
        </div>
      </div>
    </aside>
    </div>
</template>

<script>
  import Header from "@/components/main/Header";
  import UserData from "@/components/game/UserData";
  import { DateTime as LuxonDateTime } from 'luxon';
  export default {
    components: {UserData, Header},
    name: "Test",
    data() {
      return {
        isNoteOpen: false,
        isEntriesOpen: false,
        isEntryFormOpen: false,
        numPage: 1,
        entryForm: {
          actionId: null,
          victimName: '',
          victimSurname: '',
          victimPatr: '',
          victimSex: undefined,
          desc: '',
          deathDate: null,
          actionPlaceId: null
        },
          styleObject: {
            position: 'absolute',
            height: window.innerHeight * 0.42 + 'px',
            width: window.innerWidth * 0.36 + 'px',
            top: window.innerHeight * 0.16 + 'px',
            left: window.innerWidth * 0.207 + 'px',
            // border: 'red 2px solid'
          },
        minDatetime: LuxonDateTime.local().plus({seconds: 40}).toISO(),
        maxDatetime: LuxonDateTime.local().plus({ days: 2 }).toISO(),
        }
        },
          methods: {
            getKiraStatus() {
              this.$store.dispatch('getKiraStatus')
            },
            getAgentStatus() {
              this.$store.dispatch('getAgentStatus')
            },
            getKiraNews() {
              this.$store.dispatch('getKiraNews')
            },
            getAgentNews() {
              this.$store.dispatch('getAgentNews')
            },
            getNews() {
              if (this.$store.getters.isKira) {
                this.$store.dispatch('getKiraNews')
              }
              else {
                this.$store.dispatch('getAgentNews')
              }
            },
            getStatus() {
              console.log(this.$store.getters.isKira)
              if (this.$store.getters.isKira)
                this.$store.dispatch('getKiraStatus')
              else
                this.$store.dispatch('getAgentStatus')
            },
            openNote() {
              this.isNoteOpen = true
            },
            closeNote() {
              this.isNoteOpen = false
            },
            openEntryForm() {
              this.isEntryFormOpen = true
              this.isEntriesOpen = false
            },
            closeEntryForm() {
              this.isEntryFormOpen = false
            },
            openEntries() {
              this.isEntriesOpen = true
              this.isEntryFormOpen = false
            },
            closeEntries() {
              this.isEntriesOpen = false
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
            getActions() {
              if (this.$store.getters.isKira)
                this.$store.dispatch('getKiraActions')
              else
                this.$store.dispatch('getAgentActions')
            },
            getActionPlaces() {
              if (this.$store.getters.isKira)
                this.$store.dispatch('getKiraActionPlaces')
              else
                this.$store.dispatch('getAgentActionPlaces')
            },
            clearForm() {
              this.entryForm.actionId = null
              this.entryForm.victimName = ''
              this.entryForm.victimSurname = ''
              this.entryForm.victimPatr = ''
              this.entryForm.victimSex = undefined
              this.entryForm.desc = ''
              this.entryForm.deathDate = null
              this.entryForm.actionPlaceId = null
            },
            kiraWin() {
              this.$store.dispatch('kiraWin')
            },
            agentWin() {
              this.$store.dispatch('agentWin')
            },
            exit() {
              router.push("/game")
            }

          },
          mounted() {
            this.getStatus()
            this.getNews()
          },
          watch: {
            numPage: function (val) {
              this.$store.commit('setNumPage', val)
              if (this.$store.getters.isKira())
                this.getEntries()
              else
                this.getRequests()
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
  .form-control{
    border: transparent;
    margin-bottom: 5px;
    font-family:helvetica neue, helvetica, arial, sans-serif;
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


  #notebook-paper {
    -webkit-box-sizing:border-box;
    -moz-box-sizing:border-box;
    -ms-box-sizing:border-box;
    -o-box-sizing:border-box;
    box-sizing:border-box;
    background: #f1f1f1;
    font-family:helvetica neue, helvetica, arial, sans-serif;
    font-weight:200;
    width:95%;
    height:600px;
    background: linear-gradient(to bottom,white 29px,#00b0d7 1px);
    margin:0px auto;
    background-size: 100% 30px;
    position:relative;
    padding-left:8%;
    padding-right:20px;
    overflow-y: scroll;
    border-radius:5px;
    -webkit-box-shadow:3px 3px 3px rgba(0,0,0,.2),0px 0px 6px rgba(0,0,0,.2);
    -moz-box-shadow:3px 3px 3px rgba(0,0,0,.2),0px 0px 6px rgba(0,0,0,.2);
    -ms-box-shadow:3px 3px 3px rgba(0,0,0,.2),0px 0px 6px rgba(0,0,0,.2);
    -o-box-shadow:3px 3px 3px rgba(0,0,0,.2),0px 0px 6px rgba(0,0,0,.2);
    box-shadow:3px 3px 3px rgba(0,0,0,.2),0px 0px 6px rgba(0,0,0,.2);}

  #notebook-paper:before {
     content:'';
     display:block;
     position:absolute;
     z-index:1;
     top:0;
     left:7%;
     height:100%;
     width:1px;
     background:#db4034;
   }

  #content {
    margin-top:5px;
    font-size:20px;
    line-height:30px;}

  #content p {
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

  .form-note-input{
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

  .form-note-input::placeholder{
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

  #patr-field{
    margin-bottom: 0px;
  }

  #death-description{
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
