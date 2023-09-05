import {StyleSheet,Image, Text, View, Alert} from 'react-native';
import React from 'react';
import {ColorGenerator} from '../Utility/ColorGenerator';
import { Divider } from 'react-native-paper';
import Icon from 'react-native-ionicons';
import { TouchableOpacity } from 'react-native-gesture-handler';
import {openDatabase} from 'react-native-sqlite-storage';

const db = openDatabase({
  name: 'reactnative_assignment',
});

export default function Contact({contactDetails,navigation}) {
  const {name} = contactDetails;
  const color = ColorGenerator(name[0]);

  const starFunc=()=>{
    contactDetails.isStarred
      ?( db.transaction(txn => {
          txn.executeSql(
            `UPDATE contacts set isStarred=? WHERE id=${contactDetails.id}`,
            [0],
            (sqlTxn, res) => {
              console.log('unstarred');
                },
            error => {
              console.log('error unstarred' + error.message);
            },
          );
        })
      )
        
      : (db.transaction(txn => {
          txn.executeSql(
            `UPDATE contacts set isStarred=? WHERE id=${contactDetails.id}`,
            [1],
            (sqlTxn, res) => {
              console.log('starred');
              
            },
            error => {
              console.log('error starred' + error.message);
            },
          );
        }))
        Alert.alert('Successful', 'Contact added as favorite', [
          {text: 'OK', onPress: () => navigation.navigate('MyContacts')},
          {
            text: 'See Favorite Contacts',
            onPress: () => navigation.navigate('Favorite Contacts'),
            style: 'cancel',
          },
        ]);
  }
 
  return (
    <View style={styles.card}>
      <View style={styles.container}>
        {contactDetails.image != '' ? (
          <View style={styles.icon}>
            <Image source={{uri: contactDetails.image}} style={styles.icon} />
          </View>
        ) : (
          <View style={{...styles.icon, backgroundColor: color}}>
            <Text style={styles.iconImage}>{name[0]}</Text>
          </View>
        )}
        <TouchableOpacity
          onPress={() =>
            navigation.navigate('Profile', {
              contactDetails: contactDetails,
            })
          }>
          <Text style={styles.name}>{name}</Text>
        </TouchableOpacity>
        <TouchableOpacity style={styles.star} onPress={starFunc}>
          {!contactDetails.isStarred ? (
            <Icon name="star-outline" size={20} color="grey" />
          ) : (
            <Icon name="star" size={20} color="grey" />
          )}
        </TouchableOpacity>
      </View>
      <Divider style={{width: 290, marginHorizontal: 50}} />
    </View>
  );
}

const styles = StyleSheet.create({
  card: {
    padding: 1,
    margin: 5,
    height:80,
 
  },
  icon: {
    height:70,
    width:70,
    aspectRatio: 1,
    borderRadius: 45,
    alignItems: 'center',
    justifyContent: 'center',
    marginRight: 15,
    padding: 1,
    marginHorizontal: 10,
  },
  star:{
       marginLeft:80,
      
  },
  iconImage: {
    flex: 1,
    paddingVertical: 10,
    fontSize: 29,
    color: 'white',
    marginHorizontal: 20,
  },
  name: {
    fontSize: 20,
    fontWeight: '600',
    width:170,
  },
  container: {
    flex: 1,
    alignItems: 'center',
    flexDirection: 'row',
    paddingVertical: 9,
  },
});
