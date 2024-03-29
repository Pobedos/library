import {Route, Routes} from 'react-router-dom'
import About from './components/About'
import Layout from './components/Layout'
import './App.scss'

function App() {
  return (
    <>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route index element={<About />} />
        </Route>
      </Routes>
    </>
  )
}

export default App
