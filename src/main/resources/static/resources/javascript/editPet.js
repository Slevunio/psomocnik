new Vue({
     el: '#pet',
        data:{
            pet:'',
            formattedDate:'',
            elementId:'',
            updatedPet:{
                name:'',
                takeInDate:'',
                species:'',
                sex:'',
                age:'',
                canLiveWithOtherDogs:'',
                canLiveWithOtherCats:'',
                canLiveWithKids:'',
                activity:'',
                diseases:''
            }
        },
        mounted(){
           this.getPet();
        },
        beforeUpdate(){
            this.formatDate();
        },
        methods:{
            getPet(){
                axios.get('/pets/'+this.getPetId()).then(function(response){this.pet=response.data;}.bind(this));
            },
            formatDate(){
                var splitted=this.pet.takeInDate.split('T');
                this.formattedDate=splitted[0]+' '+splitted[1];
            },
             getPetId(){
                var splitted = window.location.href.split('/');
                return splitted[splitted.length-1];
            },
            setElementId(id){
                this.elementId=id;
                this.setDefaultInputValue();
            },
            setDefaultInputValue(){
                document.getElementById("editInput").value=document.getElementById(this.elementId).innerHTML;
            },
            editValue(){
                var newValue=document.getElementById("editInput").value;
                document.getElementById(this.elementId).innerHTML=newValue;
                this.updatedPet[this.elementId]=newValue;
            },
            editPet(){
                axios.put('/pets/'+this.getPetId(),{name:this.updatedPet["name"], takeInDate:this.updatedPet["takeInDate"], species:this.updatedPet["species"],
                                                    sex:this.updatedPet["sex"], age:this.updatedPet["age"],
                                                    canLiveWithOtherDogs:this.updatedPet["canLiveWithOtherDogs"],
                                                    canLiveWithOtherCats:this.updatedPet["canLiveWithOtherCats"],
                                                    canLiveWithKids:this.updatedPet["canLiveWithKids"],
                                                    activity:this.updatedPet["activity"],
                                                    diseases:this.updatedPet["diseases"]}).then(function(response){
                                                    document.location.replace("/managePets")
                                                    });
            }
        }
    });