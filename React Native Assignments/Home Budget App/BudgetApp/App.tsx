
import React from 'react'
import {createStackNavigator} from '@react-navigation/stack';
import ShowBudgets from './Pages/Screens/ShowBudgets';
import AddBudgetForm from './Pages/Screens/AddBudgetForm';
import { NavigationContainer } from '@react-navigation/native';
import 'react-native-gesture-handler';

export default function App() {
  const Stack = createStackNavigator();
  return (

  <NavigationContainer >
    <Stack.Navigator  screenOptions={{headerShown: false}} initialRouteName='addBudget'>
        <Stack.Screen  name="showBudgets" component={ShowBudgets}/>
        <Stack.Screen  name="addBudget" component={AddBudgetForm}/>
       
    </Stack.Navigator>
  </NavigationContainer> 
  
  )
}
