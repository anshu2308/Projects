import { StyleSheet,Linking,ImageBackground, Text, View, StatusBar } from 'react-native'
import React,{useEffect,useState} from 'react'
import { ActivityIndicator, Button } from 'react-native-paper';
import { ColorGenerator } from '../Utility/ColorGenerator';
import Icon from 'react-native-ionicons';
export default function Profile({navigation,route}) {
  const [contact, setContact] = useState(route.params.contactDetails);
  const [image,setImage]=useState('');


if(!contact){
  return <ActivityIndicator size={32}/>
}


  function makeCall(phoneNumber) {
    Linking.openURL(`tel:${phoneNumber}`);
  }
  return (
    <View style={styles.container}>
      {contact.image != '' ? (
        <ImageBackground
          source={{uri: contact.image}}
          style={{height: 250, width: '100%'}}
        />
      ) : (
        <Icon
          android="person"
          size={200}
          color="white"
          style={{
            backgroundColor: ColorGenerator(contact.name[0]),
            height: 250,
            paddingHorizontal: '25%',
            paddingTop: 20,
          }}
        />
      )}
      <Text style={styles.mainText}>{contact.name}</Text>

      {contact.mobile != '' ? (
        <View style={styles.call}>
          <Text style={{fontSize: 16, marginLeft: 10, color: 'black'}}>
            {contact.mobile}
          </Text>
          <Icon
            style={{marginHorizontal: 20}}
            name="call"
            size={20}
            onPress={() => makeCall(contact.mobile)}
          />
        </View>
      ) : null}
      {contact.landline != '' ? (
        <View style={styles.call}>
          <Text style={{fontSize: 16, marginLeft: 10, color: 'black'}}>
            {contact.landline}
          </Text>
          <Icon
            style={{marginHorizontal: 20}}
            name="call"
            size={20}
            onPress={() => makeCall(contact.landline)}
          />
        </View>
      ) : null}
    </View>
  );
}

const styles = StyleSheet.create({
  mainText: {
    position: 'absolute',
    top: 195,
    left: 20,
    fontSize: 30,
    color: 'white',
    fontWeight: 'bold',
  },
  call: {
    marginTop:10,
    marginHorizontal: 10,
    marginBottom: 20,
    paddingHorizontal: 10,
    elevation: 5,
    paddingVertical: 20,
    backgroundColor: 'white',
    flexDirection: 'row',
    justifyContent: 'space-between',
  },
});