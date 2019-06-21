 var app=new Vue({
        el: '#pet',
        data:{
            //Pet properties
            name:'',
            takeInDate:'',
            species:'',
            sex:'',
            age:'',
            canLiveWithOtherDogs:'',
            canLiveWithOtherCats:'',
            canLiveWithKids:'',
            activity:'',
            diseasesString:'',
            //Helpers
            diseasesArray:[],
        },

        computed:{
        },
        methods:{
            addDis(){
               this.diseasesArray.push({value:''});
            },
            diseasesToString(){
                for(var i=0; i<this.diseasesArray.length; i++){
                    if(i!=this.diseasesArray.length-1){
                        this.diseasesString+=this.diseasesArray[i].value+", ";
                    }
                    else
                        this.diseasesString+=this.diseasesArray[i].value;
                }
            },
            createPet(){

                this.diseasesToString();
                axios.post("/pets",{name:this.name, takeInDate:this.takeInDate, species:this.species, sex:this.sex, age:this.age, canLiveWithOtherDogs:this.canLiveWithOtherDogs,
                                    canLiveWithOtherCats:this.canLiveWithOtherCats, canLiveWithKids:this.canLiveWithKids, activity:this.activity,
                                    diseases:this.diseasesString}).then(function(response){document.location.replace("/managePets")});
            },
        }
    });