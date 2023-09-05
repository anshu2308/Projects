import { Alert, StyleSheet, View } from 'react-native'
import React, {useState} from 'react';
import { useDispatch} from 'react-redux';
import { Input, Button, Card, Text} from 'react-native-elements';
import { addBudget } from '../../Redux/actions';
import HeaderElement from '../Components/HeaderElement';


 const AddBudgetForm = ({navigation}) => {
   const [name, setName] = useState('');
   const [actualAmount, setActualAmount] = useState(0);
   const [plannedAmount, setPlannedAmount] = useState(0);
   const dispatch = useDispatch();

   const handleSubmit = () => {
      if(name!=''){
      
        dispatch(addBudget({name,plannedAmount,actualAmount}));
         setName('')
         setActualAmount(0)
         setPlannedAmount(0)
     Alert.alert('Success', 'Budget is added successfully', [
       {text: 'OK', onPress: () => navigation.navigate('showBudgets')},
       {
         text: 'Add More',
         onPress: () => console.log('Cancel Pressed'),
         style: 'cancel',
       },
     ]);
    ;
      }
      else{
         Alert.alert('Success', 'Budget is added successfully',
      }
   };
   return (
     <View>
       <HeaderElement />
       <Card style={styles.card} title="Add Budget Form">
         <View style={styles.container}>
           <Input
             label="Name"
             value={name}
             onChangeText={name => setName(name)}
           />
           <Input
             label="Actual Amount"
             numericvalue
             value={actualAmount}
             keyboardType="numeric"
             onChangeText={actualAmount => setActualAmount(actualAmount)}
           />
           <Input
             label="Planned Amount"
             numericvalue
             value={plannedAmount}
             keyboardType="numeric"
             onChangeText={plannedAmount => setPlannedAmount(plannedAmount)}
           />
           <Button onPress={handleSubmit} title="Add Budget" />
           <Text></Text>
           <Button
             size="sm"
             style={{width: 10}}
             title="cancel"
             type="outline"
             onPress={() => navigation.navigate('showBudgets')}
           />
         </View>
       </Card>
     </View>
   );
 };
  const styles=StyleSheet.create({
   
    container:{
      paddingTop:20
    },
  

  })
  export default AddBudgetForm
