import { Alert, StyleSheet,Button,TouchableOpacity, Text, View } from 'react-native'
import React,{useState,useEffect} from 'react'
import {Card, TextInput} from 'react-native-paper';
import Icon from 'react-native-ionicons';
import {launchImageLibrary} from 'react-native-image-picker';
import {openDatabase} from 'react-native-sqlite-storage'

const db = openDatabase({
  name: 'reactnative_assignment',
});

export default function CreateContact({navigation}) {
 const [firstName, setFirstName] = useState('');
 const [lastName, setLastName] = useState('');
 const [mobile, setMobile] = useState('');
const [selectImage, setSelectImage] = useState('');
const [landline, setLandline] = useState('');

const createTables=()=>{
  db.transaction(txn=>{
  txn.executeSql(
    `CREATE TABLE IF NOT EXISTS contacts (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(20),mobile VARCHAR(10), landline VARCHAR(10), image VARCHAR(100),isStarred INTEGER DEFAULT 0 )`,
    [],
    (sqlTxn, res) => {
      console.log('table created successfully');
    },
    error => {
      console.log('error in creating table' + error.message);
    },
  );
  })
}
useEffect(()=>{
  createTables();
},[]
)
 const addContact=()=>{
  if((mobile==''&& landline=='') || firstName.trim()=='' ){
   Alert.alert('Error','Somethign went worng');
   return false;
  }
  else{
    console.log(firstName + ' '+ lastName+ " "+ mobile+ " "+selectImage);
    db.transaction(txn=>{
      txn.executeSql(
        `INSERT INTO contacts (name,mobile,landline,image) VALUES(?,?,?,?)`,
        [firstName+' '+lastName,mobile,landline,selectImage],
        (sqlTxn,res)=>{
          console.log(` Values addded successfully`)
        },
        error=>{
          console.log('error in adding values '+error.message);
        }
      )
    })
    Alert.alert("added")
    navigation.navigate('MyContacts')
 }
 }
 const ImagePicker = () => {
   let options = {
     storageOptions: {
       path: 'image',
     },
   };

   launchImageLibrary(options, response => {
     setSelectImage(response.assets[0].uri);
   });
 };

  return (
    <View style={styles.container}>
      <Card>
        <Card.Title title="Add a Contact" />
       
        <View style={styles.inputContainer}>
          <TouchableOpacity
            onPress={() => {
              ImagePicker();
            }}
            style={{
              marginVertical: 20,
              height: 180,
              width: '55%',
              backgroundColor: '#b9c3c9',
              borderRadius: 130,
              justifyContent: 'center',
              alignItems: 'center',
              alignSelf: 'center',
            }}>
            <Icon name="camera" size={80} color="grey" />
          </TouchableOpacity>

          <TextInput
            mode="outline"
            style={styles.input}
            label="FirstName"
            value={firstName}
            onChangeText={text => setFirstName(text)}
          />
          <TextInput
            mode="outline"
            style={styles.input}
            label="LastName"
            value={lastName}
            onChangeText={text => setLastName(text)}
          />

          <TextInput
            mode="outline"
            style={styles.input}
            label=" Mobile"
            keyboardType="number-pad"
            value={mobile}
            onChangeText={text => setMobile(text)}
          />
          <TextInput
            mode="outline"
            style={styles.input}
            label="Landline"
            keyboardType="number-pad"
            value={landline}
            onChangeText={text => setLandline(text)}
          />
        </View>
        <Button title="Save" onPress={() => addContact()} />
      </Card>
    </View>
  );
}

const styles = StyleSheet.create({
  container:{
    padding:20,
  },
  inputContainer:{
    padding:20
  },
  input:{
    marginVertical:10,
  }
})