import {StyleSheet, Text, View} from 'react-native';
import React from 'react';
import {Header} from 'react-native-elements';
export default function HeaderElement() {
  return (
    <View>
      <Header
        // leftComponent={{icon: 'menu', color: '#fff'}}
        centerComponent={{
          text: 'HOME BUDGET APP',
          style: {color: '#fff', marginTop: 20,fontWeight:'bold'},
        }}
        // rightComponent={{icon: 'home', color: '#fff'}}
      />
    </View>
  );
}

const styles = StyleSheet.create({});
