import React, { useEffect, useState } from "react";
import axios from 'axios';

const Lista = () => {

    const [query, setQuery] = useState([])
    const [final, setFinal] = useState([])

    useEffect(() => {
        gerarDivs()
    }, [])

    async function getItens() {
        const x = await axios.get('http://localhost:8080/infos')


        setQuery(x.data)
        console.log("get itens")
        console.log(x)
        return x.data

    }

    function juntarPorNome(nome, data) {

        let somaFinal = 0
        const entradas = data.reduce((acc, data2) => {
            if (data2.nome_loja === nome) {

                let valor = data2.valor
                let descricao = data2.fk_tipos_trans.descricao
                let sinal = data2.fk_tipos_trans.sinal

                if (sinal) {
                    somaFinal += valor
                } else {
                    somaFinal -= valor
                }
                acc.push({ "nome": nome, "descricao": descricao, "valor": valor })
                console.log(acc)
            }

            return acc
        }, [])

        const resultado = { "nome": nome, "entradas": entradas, "total": somaFinal }
        return resultado
    }

    async function gerarDivs() {
        console.log("inicio call gerarDivs")
        const query = await getItens()
        if(query.length > 0) {
            const nomesLojas = [...new Set(query.map(x => x.nome_loja))]

            const seila = nomesLojas.map(nomes => {
                return juntarPorNome(nomes, query)
            })
    
            console.log(seila)
        
    
            const itensPorLoja = seila.map(data => {
                const nomeLoja = data.nome
                const entradas = data.entradas.map( x => {
                    let desc = x.descricao
                    let valor = x.valor
                    return (
                        <li>Descricao :{desc} / valor: {valor}</li>
                        
                    )
                })
    
                return (
                    <li>
                        <div class="divItems">
                            <div class="divInfos">{nomeLoja}</div>
                            <ol>
                        {entradas}
                            </ol>
                            <div>total: {data.total}</div>
                        </div>
                    </li>)
            }
            )
    
    
    
    
    
            setFinal(itensPorLoja)
        }
        

    }

    return (

        <div>
            {final}
        </div>

    )
}

export default Lista