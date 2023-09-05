import React, {useState, useEffect} from 'react';
import {
  View,
  Text,
  FlatList,
  StyleSheet,
  TouchableOpacity,
  Button
} from 'react-native';
import Contact from './Contact';
import {openDatabase} from 'react-native-sqlite-storage'

const db = openDatabase({
  name: 'reactnative_assignment',
});

export default function FavContacts({navigation}) {

  useEffect(() => {
    getCategories();
  }, []);


  const getCategories=()=>{
    db.transaction(txn=>{
      txn.executeSql(
        `SELECT * FROM contacts WHERE isStarred=? ORDER BY name`,
        [1],
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

  return (
    <View>
      <FlatList
        data={myContacts}
        keyExtractor={item => item.id}
        renderItem={({item}) => (
       
            <Contact contactDetails={item} />
      
        )}
        onEndReached={sortList}
      />
      <TouchableOpacity
        style={styles.addButton}
        onPress={() => {
          navigation.navigate('Create Contact');
        }}>
        <Text style={{color: '#3377ff', fontSize: 50}}>+</Text>
      </TouchableOpacity>
   
   {
    console.log(myContacts)
   }
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
});
