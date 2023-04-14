//
//  Class.swift
//  RoaryMinder
//
//  Created by Uriel Juarez on 2/24/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared
import KMMViewModelCore
import KMPNativeCoroutinesAsync
import KMPNativeCoroutinesCombine
import KMPNativeCoroutinesCore
import KMMViewModelSwiftUI
import KMPNativeCoroutinesRxSwift
import KMMViewModelCoreObjC
//struct Class {
//    let title: String
//    let description: String
//    let assignments: [Assignment]
//    let isHomePage: Bool
//
//    init(title: String, description: String, isHomePage: Bool, assignments: [Assignment] = []) {
//        self.title = title
//        self.description = description
//        self.isHomePage = isHomePage
//        self.assignments = assignments
//    }
//}

func getClassesFromDB() -> [RoaryRepoInfo] {
//    let response = RoaryViewModel().loadClasses()
    let test = [RoaryRepoInfo]()
    return test
}


func convertToList(_ mutableList: NSMutableArray?) -> [Assignments] {
    var assignments: [Assignments] = []
    
    if let unwrappedList = mutableList {
        for item in unwrappedList {
            if let assignment = item as? Assignments {
                assignments.append(assignment)
            } else {
                print("Error: Unable to cast item as shared.Assignment: \(item)")
            }
        }
    } else {
        print("Error: mutableList is nil")
    }
    
    return assignments
}






struct Test {
    var test = getClassesFromDB()
    let viewModel = RoaryViewModel()
//    let testidk = Task{
//        let result = await asyncResult(for: viewModel.getRoaryRepoInfoList())
//    }
//    let chatRepo = ChatRepos(messages: NSMutableArray(array: []))
//
//    func createTestAssignments() -> [Assignments] {
//        return [
//            Assignments(assName: "String", assDescription: "String", assChat: chatRepo),
//            Assignments(assName: "String2", assDescription: "String2", assChat: chatRepo)
//        ]
//    }
//
//    var test2: [Assignments] {
//        createTestAssignments()
//    }

//    let handle = Task {
//        do {
//            let letters = try await asyncFunction(for: RoaryViewModel().getRoaryRepoInfoList())
//            if let letters = letters as? [RoaryRepoInfo] {
//                print("yes!")
//            } else {
//                print("no :(")
//            }
//            print("Got random letters: \(String(describing: letters))")
//        } catch {
//            print("Failed with error: \(error)")
//        }
//    }
    
    
	

    // To cancel the flow (collection) just cancel the async task
//    handle.cancel()
    
    let test3 = getClassesFromDB()
    

}
