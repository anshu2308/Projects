import { StyleSheet, List,Item, Text, View, FlatList } from 'react-native'
import React from 'react'
import {useSelector} from 'react-redux';
import {ListItem,Button, Card} from '@rneui/themed';
import HeaderElement from '../Components/HeaderElement';
import AsyncStorage from '@react-native-async-storage/async-storage';
export default function ShowBudgets({navigation}) {
    
 const data = useSelector(state => state.reducer);

//  clearAsyncStorage = async () => {
//    AsyncStorage.clear();
//  };
 return (
   <View>
     <HeaderElement />
     <Card>
       <Text style={styles.headerText}>All Budgets</Text>
       {data.map(item => (
         <ListItem key={item.name} bottomDivider topDivider>
           <ListItem.Content>
             <ListItem.Title style={styles.title}>{item.name}</ListItem.Title>
             <ListItem.Subtitle>
               Actual Amount: ₹ {item.actualAmount}
             </ListItem.Subtitle>
             <Text>Planned Amount: ₹ {item.plannedAmount}</Text>
           </ListItem.Content>
         </ListItem>
       ))}

       <Button
         title="Add New Budget"
         loading={false}
         loadingProps={{size: 'small', color: 'white'}}
         buttonStyle={{
           backgroundColor: '#42adf5',
           borderRadius: 5,
         }}
         titleStyle={{fontWeight: 'bold', fontSize: 23}}
         containerStyle={{
           marginHorizontal: 60,
           height: 50,
           width: 200,
           marginVertical: 20,
         }}
         onPress={() => navigation.navigate('addBudget')}
       />
       {/* <Button onPress={this.clearAsyncStorage}>
         <Text>Clear Async Storage</Text>
       </Button> */}
     </Card>
   </View>
 );
}

const styles = StyleSheet.create({
  headerText:{
    fontWeight:'bold',
    fontSize:24,
    color:'#03a9fc',
    left:100
  },
  title:{
    fontWeight: 'bold',
  marginHorizontal:3,
  fontSize:20,
}
})