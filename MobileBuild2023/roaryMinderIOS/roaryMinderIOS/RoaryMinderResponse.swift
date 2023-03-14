//
//  RoaryMinderResponse.swift
//  RoaryMinder
//
//  Created by Camila on 3/6/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation

func getRoaryMinderResponse(message: String) -> String {
    let tempMessage = message.lowercased()
    
    if tempMessage.contains("Hello"){
        return "Random text message hereRandom text message"
    }else if tempMessage.contains("Hi"){
        return "Random text"
    }else{
        return "Random text messagemhereRandom text message hereRandom text message hereRandom text message hereRandom text message here"
    }
}
