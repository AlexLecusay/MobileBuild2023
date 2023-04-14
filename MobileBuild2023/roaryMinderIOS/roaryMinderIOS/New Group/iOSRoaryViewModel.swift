//
//  iOSRoaryViewModel.swift
//  RoaryMinder
//
//  Created by Uriel Juarez on 4/14/23.
//  Copyright © 2023 orgName. All rights reserved.
//


import Foundation
import shared
import KMPNativeCoroutinesAsync

@MainActor
class iOSRoaryViewModel: ObservableObject {
    @Published var classes = [RoaryRepoInfo]()
    
    private let repository: RoaryViewModel
    private var observationTask: Task<Void, Error>? = nil
    
    init(repository: RoaryViewModel) {
        self.repository = repository
        startObservingClasses()
         testValuesReceived()
    }
    func getRepo() -> RoaryViewModel{
        return self.repository
    }
    func startObservingClasses() {
        //        observationTask = Task<Void, Error> {
        //            do {
        //                let sequence = try await asyncSequence(for: repository.getRoaryRepoInfoList())
        //                for try await data in sequence {
        //                    self.classes = data
        //                }
        //            } catch {
        //                print("Failed with error: \(error)")
        //            }
        //        }
    }
    func testValuesReceived()  {
        observationTask = Task{
            do{
                let integrationTests = RoaryViewModel()
                let sequence = asyncSequence(for: integrationTests.roaryRepoInfoList)
                for try await data in sequence{
                    self.classes = data
                }
            }catch{
                print("error")
            }
        }
       
//        func stopObservingClasses() {
//            observationTask?.cancel()
//        }
    }
}
