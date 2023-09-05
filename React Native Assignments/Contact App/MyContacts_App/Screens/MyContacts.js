import React, {useState, useEffect} from 'react';
import {
  View,
  Text,
  StyleSheet,
  TouchableOpacity,

  Alert
} from 'react-native';
import Swipelist from 'react-native-swipeable-list-view';
import Contact from './Contact';
import {openDatabase} from 'react-native-sqlite-storage'


const db = openDatabase({
  name: 'reactnative_assignment',
});

export default function MyContacts({navigation}) {

  useEffect(() => {
    getContacts();
  }, [myContacts]);


  const getContacts=()=>{
    db.transaction(txn=>{
      txn.executeSql(
        `SELECT * FROM contacts ORDER BY name`,
        [],
        (sqlTxn,res)=>{
          console.log('Contacts retrieved successfully');
          let len=res.rows.length;
          
          if(len>0){
            let result=[];
            for(let i=0;i<len;i++){
              let item=res.rows.item(i);
              result.push({id:item.id,name:item.name,mobile:item.mobile,landline:item.landline,image:item.image,isStarred:item.isStarred});
            }
             setMyContacts(result);
            console.log(myContacts);
;          }
        },
        error=>{
          console.log('error in retrieving contacts'+error.message)
        }
      )
    })
  }
  const [myContacts,setMyContacts] = useState([]);

    const sortList = () => {
      const sortedItems = myContacts.sort();
      setMyContacts(sortedItems);
    };

    function handleDelete(id){
      console.log(id);
      db.transaction(txn=>{
        txn.executeSql(
          `DELETE FROM contacts WHERE id=?`,
          [id],
           (sqlTxn,res)=>{
          console.log('Contacts deleted successfully');
          getContacts()
           },
        error=>{
          console.log('error in deleting contacts'+error.message)
        }
        )
      })
    }
  
    const deleteContact = id =>
      Alert.alert('Delete', 'Confirm Delete', [
        {text: 'OK', onPress: () => handleDelete(id)},
        {
          text: 'cancel',
          onPress: () => navigation.navigate('MyContacts'),
          style: 'cancel',
        },
      ]);
  return (
    <View>
      <Swipelist
        data={myContacts}
        renderRightItem={(data, id) => (
          <Contact contactDetails={data} navigation={navigation} />
        )}
        onEndReached={sortList}
        renderHiddenItem={(data, index) => (
          <View style={{flexDirection: 'row'}}>
            <TouchableOpacity
              style={styles.button}
              onPress={() =>
                navigation.navigate('Update Contact', {
                  contactDetails: data,
                })
              }>
              <Text style={{color: 'white', fontSize: 20, fontWeight: 'bold'}}>
                Edit
              </Text>
            </TouchableOpacity>
            <TouchableOpacity
              style={styles.delButton}
              onPress={() => deleteContact(data.id)}>
              <Text style={{color: 'white', fontSize: 20, fontWeight: 'bold'}}>
                Delete
              </Text>
            </TouchableOpacity>
          </View>
        )}
        rightOpenValue={200}
      />
      <TouchableOpacity
        style={styles.addButton}
        onPress={() => {
          navigation.navigate('Create Contact');
        }}>
        <Text style={{color: '#3377ff', fontSize: 50}}>+</Text>
      </TouchableOpacity>
    </View>
  );
}

const styles = StyleSheet.create({
  addIcon: {},
  addButton: {
    alignItems: 'center',

    width: 70,
    elevation: 8,
    position: 'absolute',
    top: 610,
    right: 20,
    height: 70,
    backgroundColor: 'white',
    borderRadius: 100,
  },
  button: {
    backgroundColor: 'skyblue',
    flex: 1,
    justifyContent: 'center',
    
    alignItems: 'center',
    width: '100%',
    height: 100,
  },
  delButton: {
    backgroundColor: 'red',
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    width: '100%',
    height: 100,
  },
});
