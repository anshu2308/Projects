import { StyleSheet, Text,Alert, View,TouchableOpacity,Button } from 'react-native'
import React,{useState} from 'react'
import {openDatabase} from 'react-native-sqlite-storage'
import {Card, TextInput} from 'react-native-paper';
import Icon from 'react-native-ionicons';
import {launchImageLibrary} from 'react-native-image-picker';
const db = openDatabase({
  name: 'reactnative_assignment',
});
export default function UpdateContact({navigation,route}) {
  const contact = route.params.contactDetails;

  const [name, setName] = useState(contact.name);
  const [mobile, setMobile] = useState(contact.mobile);
  const [selectImage, setSelectImage] = useState(contact.image);
  const [landline, setLandline] = useState(contact.landline);

const editContact=()=>{
  if (mobile == '' && landline == '') {
    Alert.alert('Error', 'Somethign went worng');
    return false;
  } else {
    db.transaction(txn => {
      txn.executeSql(
        `UPDATE contacts set mobile=?,landline=?,image=? WHERE id=?`,
        [mobile, landline, selectImage,contact.id],
        (sqlTxn, res) => {
          console.log(` Values Updated successfully`);
        },
        error => {
          console.log('error in updating values ' + error.message);
        },
      );
    });
    Alert.alert('Updated');
    navigation.navigate('MyContacts');
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
    <View>
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
              width: '50%',
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
            label="Name"
            disabled='true'
            value={name}
            onChangeText={text => setName(text)}
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
        <Button title="Save" onPress={() => editContact()} />
      </Card>
    </View>
  );
}

const styles = StyleSheet.create({
  inputContainer: {
    padding: 20,
  },
  input: {
    marginVertical: 10,
  },
});