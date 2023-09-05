/**
 * @format
 */

import {AppRegistry} from 'react-native';
import React from 'react';
import App from './App';
import {name as appName} from './app.json';
import {Provider} from 'react-redux';
import Store from './Redux/store';
import {PersistGate} from 'redux-persist/integration/react';
export const RNRedux = () => (
  <Provider store={Store.store}>
    <PersistGate persistor={Store.persistor}>
      <App />
    </PersistGate>
  </Provider>
);
AppRegistry.registerComponent(appName, () => RNRedux);