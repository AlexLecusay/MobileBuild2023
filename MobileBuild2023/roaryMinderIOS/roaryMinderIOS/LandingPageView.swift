//
//  LandingPageView.swift
//  RoaryMinder
//
//  Created by Uriel Juarez on 2/25/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct LandingPageView: View {
    @State private var searchText = ""
    @State private var isMenuVisible = false
    @State private var isHomePage = false
    
    var body: some View {
        VStack {
            HStack {
                Text(isHomePage ? "My Classes" : "All Classes")
                    .font(.title)
                    .fontWeight(.bold)
                
                Spacer()
                
                Button(action: {
                    isMenuVisible.toggle()
                }) {
                    Image(systemName: "line.horizontal.3")
                        .foregroundColor(.black)
                }
                .padding(.trailing, 8)
            }
            .padding(.horizontal)
            .padding(.top, 16)
            
            SearchBarView(text: $searchText)
                .padding(.horizontal)
                .padding(.bottom, 8)
            
            if isMenuVisible {
                SideMenuView(isHomePage: $isHomePage)
            }
            
            ClassListComponent(classes: Test().test)
                .padding(.horizontal)
                .padding(.bottom, 16)
            
            Spacer()
        }
    }
}



struct LandingPageView_Previews: PreviewProvider {
    static var previews: some View {
        LandingPageView()
    }
}
