import MyContacts from './Screens/MyContacts';
import CreateContact from './Screens/CreateContact';
import Profile from './Screens/Profile';
import 'react-native-gesture-handler';
import React from 'react';
import {NavigationContainer} from '@react-navigation/native';
import {createStackNavigator} from '@react-navigation/stack';
import FavContacts from './Screens/FavContacts';
import UpdateContact from './Screens/UpdateContact';

const Stack=createStackNavigator();

export default function App(){
return(
 <NavigationContainer>
  <Stack.Navigator initialRouteName='MyContacts'>
        <Stack.Screen name="MyContacts" component={MyContacts}/>
        <Stack.Screen name="Profile" component={Profile} />
        <Stack.Screen name="Create Contact" component={CreateContact}/>
        <Stack.Screen name="Favorite Contacts" component={FavContacts}/>  
        <Stack.Screen name="Update Contact" component={UpdateContact}/>
    </Stack.Navigator>
 </NavigationContainer>
)
}